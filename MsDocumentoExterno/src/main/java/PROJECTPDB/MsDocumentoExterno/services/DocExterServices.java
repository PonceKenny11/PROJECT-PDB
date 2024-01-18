package PROJECTPDB.MsDocumentoExterno.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import PROJECTPDB.MsDocumentoExterno.DTO.DocumentRequest;
import PROJECTPDB.MsDocumentoExterno.DTO.DocumentResponse;
import PROJECTPDB.MsDocumentoExterno.Mapper.DocMapper;
import PROJECTPDB.MsDocumentoExterno.models.Entity.DocExterModels;
import PROJECTPDB.MsDocumentoExterno.repository.DocExterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocExterServices {

    private final DocExterRepository _DocExterRepository;

    public List<DocExterModels> getAll() {
        return (List<DocExterModels>) _DocExterRepository.findAll();
    }

    public DocumentResponse ExisteOrNoDocument(Integer docID) {
              Optional<DocExterModels> documentOpticional = _DocExterRepository.findById(docID);// Intenta obtener un
                                                                                          // documento externo de la
                                                                                          // base de datos con el metodo
                                                                                          // del repositorio
        // l resultado se coloca en un Optional porque el documento puede o no existir.
        log.info("Se Obtuvo por id: {}", docID);
        if (documentOpticional.isPresent()) {// Verifica si el Optional tiene un valor presente, es decir, si se ha
                                             // encontrado un documento con el ID proporcionado.
            DocExterModels documentEntity = documentOpticional.get();
            log.debug("Si existe Documento -> {}", documentOpticional);
            return DocMapper.mapToDocResponse(documentEntity);
        } else {
            log.error("No existe datos con este id: {}", docID);
            return null;
        }
    }

    public void crearDocumento(DocumentRequest documentoRequest) {
        DocExterModels documento = DocMapper.mapToDocEntity(documentoRequest);
        _DocExterRepository.save(documento);

    }

    public void eliminarDocumento(Integer id) {
        var ExistDocument = ExisteOrNoDocument(id);
        if (ExistDocument != null) {

            _DocExterRepository.deleteById(id);
            log.info("Documento Eliminado Con Exito!");
        } else {
            log.error("No existe datos con este id: {}", id);
        }

    }

    public DocumentResponse actualizarDocumento(DocumentRequest documentoReq) {
        DocExterModels documentoEntity = _DocExterRepository.findById(documentoReq.getIdDoc()).get();

        updatePropertiesDocument(documentoReq, documentoEntity);

        DocExterModels documentoModificado = _DocExterRepository.save(documentoEntity);

        return DocMapper.mapToDocResponse(documentoModificado); //

    }

    private void updatePropertiesDocument(DocumentRequest documentReq, DocExterModels documentEntity) {
        Field[] Atributos = documentReq.getClass().getDeclaredFields();

        for (Field atributo : Atributos) {
            try {
                Field properties_docEntity = documentEntity.getClass().getDeclaredField(atributo.getName());
                properties_docEntity.setAccessible(true);
                atributo.setAccessible(true);
                properties_docEntity.set(documentEntity, atributo.get(documentReq));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();

            }
        }
    }

}
