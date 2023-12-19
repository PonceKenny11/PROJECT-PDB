package PROJECTPDB.MsDocumentoExterno.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PROJECTPDB.MsDocumentoExterno.models.DocExterModels;
import PROJECTPDB.MsDocumentoExterno.repository.DocExterRepository;

@Service
public class DocExterServices {
    public DocExterServices(){

    }
    
    @Autowired
    DocExterRepository _DocExterRepository;

    public List<DocExterModels> getAll(){
        return (List<DocExterModels>) _DocExterRepository.findAll();
    }

    public DocExterModels obtenerDocPorId(int id) {
        return _DocExterRepository.findById(id).orElse(null);
    }

    public DocExterModels crearDoc(DocExterModels documento) {
        return _DocExterRepository.save(documento);
    }

    public void eliminarDoc(int id) {
         _DocExterRepository.deleteById(id);
    }

    public DocExterModels actualizarUsuario(DocExterModels documentoExterActualizado) {
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

  
    
    
}
