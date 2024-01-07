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
  

    public List<DocExterModels> getAll(){
        return (List<DocExterModels>) _DocExterRepository.findAll();
    }


    public DocumentResponse obtenerPorId(Integer id){
        Optional<DocExterModels> documentOpticional = _DocExterRepository.findById(id);

        if (documentOpticional != null) {
            DocExterModels documentEntity = documentOpticional.get();
            log.info("Se Obtuvo por id: {}", id);
            return DocMapper.mapToDocResponse(documentEntity);
        }else{
            log.error("No existe este id{}");
            return null;
        }
    }

    public void crearDocumento(DocumentRequest documentoRequest) {
        var document = DocMapper.mapToDocEntity(documentoRequest); 
         _DocExterRepository.save(document);

    }

    public void eliminarDoc(int id) {
         _DocExterRepository.deleteById(id);
    }

  /*  public DocExterModels actualizarUsuario(DocExterModels documentoExterActualizado) {
        
        DocExterModels documentoExter = _DocExterRepository.findById(documentoExterActualizado.IdDocExt).orElse(null);
        if (documentoExter != null) {
            documentoExter.setNombreArchivo(documentoExterActualizado.getNombreArchivo());
            documentoExter.setCodigoDocumento(documentoExterActualizado.getCodigoDocumento());
            documentoExter.setFechaEmision(documentoExterActualizado.getFechaEmision());
            documentoExter.setFechaRecepcion(documentoExterActualizado.getFechaRecepcion());
            documentoExter.setAsuntoDoc(documentoExterActualizado.getAsuntoDoc());
            documentoExter.setEstadoDoc(documentoExterActualizado.getEstadoDoc());
            documentoExter.setNumeroFolio(documentoExterActualizado.getNumeroFolio());
            documentoExter.setTipoDocumento(documentoExterActualizado.getTipoDocumento());
            
            return _DocExterRepository.save(documentoExter); 

        }
        return null;
    }
  */
    
    
}
