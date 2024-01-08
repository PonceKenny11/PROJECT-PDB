package PROJECTPDB.MsDocumentoExterno.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import PROJECTPDB.MsDocumentoExterno.models.DTO.DocumentRequest;
import PROJECTPDB.MsDocumentoExterno.models.DTO.DocumentResponse;
import PROJECTPDB.MsDocumentoExterno.models.Entity.DocExterModels;
import PROJECTPDB.MsDocumentoExterno.services.DocExterServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;





@RestController
@RequestMapping("/api/documentos/externo")
@RequiredArgsConstructor
@Slf4j
public class DocExterController {
    

    private final DocExterServices documentServices;


    @GetMapping
    public ResponseEntity<?> getAllDocuments(){
        try {
            List<DocExterModels> documents = documentServices.getAll();
            return new ResponseEntity<>(documents, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            log.error("Error en Obtener datos", e);
            return new ResponseEntity<>("Error en el Servidor, Intentelo mas tarde!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getOneDocument(@PathVariable Integer id) {
        try {
            DocumentResponse document = documentServices.ExisteOrNoDocument(id);
            if (document != null) {
                return new ResponseEntity<>(document, HttpStatus.OK);
            }else{
                return new ResponseEntity<String>("No Existe Documento Externo", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Error en manejo de excepciones"+e);
            return new ResponseEntity<String>("Error en servidor para obtener datos Documentos", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    @PostMapping("/crear")
    public ResponseEntity<?> crearDocumento(@RequestBody DocumentRequest documento) {
        try {
            // Estas recibiendo el Request, a ese request debes mapearlo al model , El request esta mapeado al model que lo considero como entity
            documentServices.crearDocumento(documento);
            return new ResponseEntity<String>("Nuevo Documento Created Succefull!", HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error de manejo de excepciones al crear el documento", e);
          return new ResponseEntity<String>("No se pudo crear el documento. Por favor, inténtelo de nuevo más tarde.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
 
    }

  


    /*@PutMapping("/editar")
    public ResponseEntity<?> ActualizarDocumento(@RequestBody DocExterModels documentoModel) {
    try {
        
        DocExterModels documento = docExterServices.actualizarUsuario(documentoModel);
        return new ResponseEntity<>(documento, HttpStatus.OK);
    } catch (Exception e) {
        log.error("Error en manejo de excepcion", e);
        return new ResponseEntity<>("Error en actualizar documento en el servidor",HttpStatus.INTERNAL_SERVER_ERROR);
    }


    }*/
    

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDocumento(@PathVariable Integer id){
        try {
            documentServices.eliminarDocumento(id);
            return new ResponseEntity<String>("El Documento Externo ha Sido Eliminado",HttpStatus.FOUND);
        } catch (Exception e) {
            log.error("Error al eliminar el documento", e);
            return new ResponseEntity<>("No se Pudo eliminar el Documento",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


        
}

