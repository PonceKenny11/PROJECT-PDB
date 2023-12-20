package PROJECTPDB.MsDocumentoExterno.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;  // Importa la clase LoggerFactory
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PROJECTPDB.MsDocumentoExterno.models.DocExterModels;
import PROJECTPDB.MsDocumentoExterno.services.DocExterServices;



@RestController
@RequestMapping("/api/documentos")
public class DocExterController {
    
    // Declara una instancia de Logger
    private static final Logger log = LoggerFactory.getLogger(DocExterController.class);

    @Autowired
    private DocExterServices docExterServices;


    @GetMapping
    public ResponseEntity<?> getAllDocuments(){
        try {
            List<DocExterModels> documents = docExterServices.getAll();
            return new ResponseEntity<>(documents, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error en "+e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getOneDocument(@PathVariable int id) {
        try {
            DocExterModels document = docExterServices.obtenerDocPorId(id);
            if (document != null) {
                return new ResponseEntity<>(document, HttpStatus.OK);
            }else{
                return new ResponseEntity<>("No Existe Documento Externo", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Error en "+e);
            return new ResponseEntity<>("Documento ...", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    @PostMapping("/crear")
    public ResponseEntity<?> crearDocumento(@RequestBody DocExterModels documento) {
        try {
            DocExterModels nuevoDocumento = docExterServices.crearDoc(documento);
            return new ResponseEntity<>(nuevoDocumento, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception for developer
            log.error("Error al crear el documento", e);

            // Return a user-friendly error message
            return new ResponseEntity<>("No se pudo crear el documento. Por favor, inténtelo de nuevo más tarde.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDocumento(@PathVariable int id){
        try {
            docExterServices.eliminarDoc(id);
            log.info("Documento Eliminado Con Exito!");
            return new ResponseEntity<>("El Documento Externo ha Sido Eliminado",HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al eliminar el documento", e);
            return new ResponseEntity<>("No se Pudo eliminar el Documento",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


        
}

