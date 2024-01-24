package PROJECTPDB.MsDocumentoExterno.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
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
//import PROJECTPDB.MsDocumentoExterno.services.DocExterSend;
import PROJECTPDB.MsDocumentoExterno.services.DocExterServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/documentos/externo")
@RequiredArgsConstructor
@Slf4j
public class DocExterController extends MessageAbstract {

    private final DocExterServices documentServices;
    private final KafkaTemplate<Integer, String> kafkaTemplate;


    @GetMapping
    public ResponseEntity<?> getAllDocuments() {
        try {
            List<DocExterModels> documents = documentServices.getAccesAll();
            return ResponseEntity.status(HttpStatus.FOUND).body(documents);
        } catch (Exception e) {
            log.error(MSG_EXCEP, e);
            return new ResponseEntity<>(MSG_SERVER, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("buscar/{id}")
    public ResponseEntity<?> BuscarOneDocument(@PathVariable Integer id) {
        try {
            if (documentServices.ExisteOrNoDocumento(id)) {
                log.info(MSG_EXIST(true), id);
                DocumentResponse document = documentServices.searchDocumento(id);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("Documento Encontrado => ", document);
                return ResponseEntity.status(HttpStatus.FOUND).body(map);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MSG_EXIST(false));
            }
        } catch (Exception e) {
            log.error(MSG_EXCEP + e);
            return new ResponseEntity<String>(MSG_SERVER, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("enviar-recepcion/{iddocument}")
    public ResponseEntity<?> EnviarRecepcion(@PathVariable Integer iddocument) {
        try {
            if (documentServices.ExisteOrNoDocumento(iddocument)) {

                String idstr = String.valueOf(iddocument);
                log.info(MSG_EXIST(true)+idstr);
                kafkaTemplate.send("spring.kafka.template.default-topic", idstr);
                return ResponseEntity.status(HttpStatus.FOUND).body(MSG_CORRECT);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MSG_EXIST(false));
            }
        } catch (Exception e) {
            log.error(MSG_EXCEP + e);
            return new ResponseEntity<String>(MSG_SERVER, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearDocumento(@RequestBody DocumentRequest documentoReq) {
        try {
            // Estas recibiendo el Request, a ese request debes mapearlo al model ,
            // Elrequest esta mapeado al model que lo considero como entity
            if (documentoReq.equals(null)) {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(MSG_EMPTY);
            } else {
                documentServices.crearDocumento(documentoReq);
                return ResponseEntity.status(HttpStatus.CREATED).body(MSG_CREATED);
            }
        } catch (Exception e) {
            log.error(MSG_EXCEP, e);
            return new ResponseEntity<String>(MSG_SERVER, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/edit")
    public ResponseEntity<?> cambioDocumental(@RequestBody DocumentRequest documentReq) {
        try {
            if (documentReq != null) {
                DocumentResponse documento = documentServices.actualizarDocumento(documentReq);

                Map<String, Object> resMap = new HashMap<>();
                resMap.put(MsageUpdate(true), documento);

                return ResponseEntity.status(HttpStatus.ACCEPTED).body(resMap);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MSG_EXIST(false));
            }
        } catch (Exception e) {
            log.error(MSG_EXCEP, e);
            return new ResponseEntity<>(MSG_SERVER, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDocumento(@PathVariable Integer id) {
        try {
            if (id.equals(null)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(MSG_EXIST(false));
            } else {
                documentServices.eliminarDocumento(id);
                log.info(MSG_EXIST(true), id);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(MSG_DELETE);
            }
        } catch (Exception e) {
            log.error(MSG_EXCEP, e);
            return new ResponseEntity<>(MSG_SERVER, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
