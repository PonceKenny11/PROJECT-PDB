package PROJECTPDB.MsDocumentoExterno.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PROJECTPDB.MsDocumentoExterno.DTO.DocumentRequest;
import PROJECTPDB.MsDocumentoExterno.DTO.DocumentResponse;
import PROJECTPDB.MsDocumentoExterno.Parametrizacion.MessageAbstract;
import PROJECTPDB.MsDocumentoExterno.models.Entity.DocExterModels;
import PROJECTPDB.MsDocumentoExterno.services.DocExterServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/documentos/externo")
@RequiredArgsConstructor
@Slf4j
public class DocExterController extends MessageAbstract{

    private final DocExterServices documentServices;

    @GetMapping
    public ResponseEntity<?> getAllDocuments() {
        try {
            List<DocExterModels> documents = documentServices.getAll();
            return new ResponseEntity<>(documents, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            log.error(MSG_EX, e);
            return new ResponseEntity<>(MSG_SERVER, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneDocument(@PathVariable Integer id) {
        try {
            DocumentResponse document = documentServices.ExisteOrNoDocument(id);
            if (document != null) {
                return new ResponseEntity<>(document, HttpStatus.OK);
            } else {
                return new ResponseEntity<String>(MSG_EXIST, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error(MSG_EX+ e);
            return new ResponseEntity<String>(MSG_SERVER,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearDocumento(@RequestBody DocumentRequest documento) {
        try {
            // Estas recibiendo el Request, a ese request debes mapearlo al model , El
            // request esta mapeado al model que lo considero como entity
            documentServices.crearDocumento(documento);
            return new ResponseEntity<String>(MSG_CREATED, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(MSG_EX, e);
            return new ResponseEntity<String>(MSG_SERVER, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/edit")
    public ResponseEntity<?> cambioDocumental(@RequestBody DocumentRequest documentReq) {
        try {
            if(documentReq != null)
            {
                DocumentResponse documento = documentServices.actualizarDocumento(documentReq);

                Map<String, Object> resMap = new HashMap<>();
                resMap.put(MsageUpdate(true), documento);
      

                return new ResponseEntity<>(resMap, HttpStatus.OK);
            }else{
                return new ResponseEntity<String>(MsageUpdate(false), HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            log.error(MSG_EX, e);
            return new ResponseEntity<>(MSG_SERVER,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDocumento(@PathVariable Integer id) {
        try {

          documentServices.eliminarDocumento(id);
            return new ResponseEntity<String>(MSG_DELETE, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            log.error(MSG_EX, e);
            return new ResponseEntity<>(MSG_SERVER, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
    