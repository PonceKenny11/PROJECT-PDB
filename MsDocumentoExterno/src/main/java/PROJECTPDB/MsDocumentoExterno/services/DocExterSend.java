package PROJECTPDB.MsDocumentoExterno.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class DocExterSend {

    @Value("${spring.kafka.template.default-topic}")
    String topicName;

    @Autowired
    KafkaTemplate<Integer, Object> _kafka;

    public void PublishRecepcionarDocumento(String msgeJSON, Integer idDocument) throws JsonProcessingException{
        Map<String, Integer> ResponseMap = new HashMap<String, Integer>();
        
        ResponseMap.put(msgeJSON, idDocument);

        _kafka.send(topicName, ResponseMap);
    } 

}
