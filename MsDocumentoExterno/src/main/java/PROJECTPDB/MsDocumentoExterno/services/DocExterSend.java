package PROJECTPDB.MsDocumentoExterno.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Component
@NoArgsConstructor
@AllArgsConstructor
public class DocExterSend {

    @Autowired
    KafkaTemplate<String, Object> _kafka;

    public void PublishRecepcionarDocumento(String msgeJSON, Integer idDocument) throws JsonProcessingException{
        if (_kafka != null) { // Asegúrate de que _kafka y topicName estén inicializados
            Map<String, Integer> ResponseMap = new HashMap<String, Integer>();
            ResponseMap.put(msgeJSON, idDocument);
            _kafka.send("spring.kafka.template.default-topic", ResponseMap);
        } else {
            // Manejar el caso en el que _kafka o topicName son nulos
            throw new IllegalStateException("La instancia de KafkaTemplate o el nombre del tema no han sido inicializados correctamente.");
        }
    } 

}
