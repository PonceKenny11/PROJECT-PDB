package PROJECTPDB.MsDocumentoExterno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import PROJECTPDB.MsDocumentoExterno.models.DTO.DocMapper;
import PROJECTPDB.MsDocumentoExterno.models.DTO.DocumentRequest;
import PROJECTPDB.MsDocumentoExterno.models.DTO.DocumentResponse;
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
        Optional<DocExterModels> documentOpticional = _DocExterRepository.findById(docID);// Intenta obtener un documento externo de la base de datos con el metodo del repositorio
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
        var documento = DocMapper.mapToDocEntity(documentoRequest);
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

 
    /*
     * public DocExterModels actualizarUsuario(DocExterModels
     * documentoExterActualizado) {
     * 
     * DocExterModels documentoExter =
     * _DocExterRepository.findById(documentoExterActualizado.IdDocExt).orElse(null)
     * ;
     * if (documentoExter != null) {
     * documentoExter.setNombreArchivo(documentoExterActualizado.getNombreArchivo())
     * ;
     * documentoExter.setCodigoDocumento(documentoExterActualizado.
     * getCodigoDocumento());
     * documentoExter.setFechaEmision(documentoExterActualizado.getFechaEmision());
     * documentoExter.setFechaRecepcion(documentoExterActualizado.getFechaRecepcion(
     * ));
     * documentoExter.setAsuntoDoc(documentoExterActualizado.getAsuntoDoc());
     * documentoExter.setEstadoDoc(documentoExterActualizado.getEstadoDoc());
     * documentoExter.setNumeroFolio(documentoExterActualizado.getNumeroFolio());
     * documentoExter.setTipoDocumento(documentoExterActualizado.getTipoDocumento())
     * ;
     * 
     * return _DocExterRepository.save(documentoExter);
     * 
     * }
     * return null;
     * }
     */

}
