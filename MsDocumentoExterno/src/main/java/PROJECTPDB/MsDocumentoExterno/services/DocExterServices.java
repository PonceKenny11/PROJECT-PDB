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

    public List<DocExterModels> getAccesAll() {
        return (List<DocExterModels>) _DocExterRepository.findAll();
    }

    public DocumentResponse searchDocumento(Integer docID) {
        // return documentOpticional.isPresent() ?DocMapper.mapToDocResponse(documentEntity) : null;
        /*
         * Intenta obtener undocumento externo de labase de datos con el metodo del repositorio
         */
        if (ExisteOrNoDocumento(docID)) {
            Optional<DocExterModels> documentOpticional = _DocExterRepository.findById(docID);
            // El resultado se coloca en un Optional porque el documento puede o no existir.
            DocExterModels documentEntity = documentOpticional.get();
            log.debug("Documento Opticional -> {}", documentOpticional);
            return DocMapper.mapToDocResponse(documentEntity);
        }
        return null;
    }

    public Boolean ExisteOrNoDocumento(Integer docID) {
        Optional<DocExterModels> documentOpticional = _DocExterRepository.findById(docID);
        return documentOpticional.isPresent();// Verifica si el Optional tiene un valor presente, es decir, si se ha
                                              // encontrado un documento con el ID proporcionado.
    }

    public void crearDocumento(DocumentRequest documentoRequest) {
        DocExterModels documento = DocMapper.mapToDocEntity(documentoRequest);
        _DocExterRepository.save(documento);
    }

    public void eliminarDocumento(Integer id) {
        _DocExterRepository.deleteById(id);
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
