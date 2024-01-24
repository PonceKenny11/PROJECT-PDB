package PROJECTPDB.MsRecepcion.controller;

import org.springframework.web.bind.annotation.RestController;

import PROJECTPDB.MsRecepcion.Configuraciones.MessagesRecep;
import PROJECTPDB.MsRecepcion.DTO.RequestRecep;
import PROJECTPDB.MsRecepcion.models.RecepModels;
import PROJECTPDB.MsRecepcion.services.IRecepServicio;
import PROJECTPDB.MsRecepcion.services.RecepService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api-recepcion")
@RequiredArgsConstructor
@Slf4j
public class RecepController extends MessagesRecep{
    
    private final RecepService servicios;
    private final IRecepServicio servicio2;
    @PostMapping("/register")
    public ResponseEntity<?> recepcionandoDocumento(@RequestBody RequestRecep requestRecep) {
        try {
            Map<String, String> respuestaJson = new HashMap<String, String>();

            if(requestRecep != null){
                log.info(FUNC_MSG_COMPLETED(1) +" {}", requestRecep);

                servicio2.setRecepModels(requestRecep);
                Boolean hasCreated = servicio2.getHasCreated();
                log.info("obteniendo ID de Listener: {}",servicio2.getIdDocumentaso());
                log.info("obteniendo Object deListener: {}",servicio2.getRecepModels());
            if (hasCreated != null && hasCreated.booleanValue()) {
                respuestaJson.put("Successful:", FUNC_MSG_EXIST_DOC(1));
            } else {
                respuestaJson.put("Failed:", FUNC_MSG_EXIST_DOC(0));
                log.warn(MSG_ID);
            }
            }else{
                log.debug(FUNC_MSG_COMPLETED(0), requestRecep);
            }
            
            return ResponseEntity.status(HttpStatus.CREATED).body(respuestaJson);
        } catch (Exception e) {
            log.error(MSG_EXCEPTIONS, e);
            return new ResponseEntity<String>(MSG_SERVER, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    @GetMapping
    public ResponseEntity<?> getAllDocuments() {
        try {
            List<RecepModels> entityList = servicios.getAccesAll();
            return ResponseEntity.status(HttpStatus.FOUND).body(entityList);
        } catch (Exception e) {
            log.error(MSG_EXCEPTIONS, e);
            return new ResponseEntity<>(MSG_SERVER, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
