package PROJECTPDB.MsRecepcion.controller;

import org.springframework.web.bind.annotation.RestController;

import PROJECTPDB.MsRecepcion.Configuraciones.MessagesRecep;
import PROJECTPDB.MsRecepcion.DTO.RequestRecep;
import PROJECTPDB.MsRecepcion.services.RecepService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/recepcion")
@RequiredArgsConstructor
@Slf4j
public class RecepController extends MessagesRecep{
    
    private final RecepService servicios;

    @PostMapping("/register")
    public ResponseEntity<?> recepcionandoDocumento(@RequestBody RequestRecep requestRecep) {
        try {
            Map<String, String> respuestaJson = new HashMap<String, String>();

            if(requestRecep != null){
                log.info(FUNC_MSG_COMPLETED(1));

                servicios.setRecepModels(requestRecep);
                
                if (servicios.getHasCreated()) {
                    respuestaJson.put("Succeful:", FUNC_MSG_EXIST_DOC(1));
                }else{
                    respuestaJson.put("Faild:", FUNC_MSG_EXIST_DOC(0));
                    log.warn(MSG_ID);
                }
            }else{
                log.debug(FUNC_MSG_COMPLETED(0), requestRecep);
            }
            
            return ResponseEntity.status(HttpStatus.CREATED).body(respuestaJson);
        } catch (Exception e) {
            log.error(MSG_EXCEPTIONS, e);
            return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

}
