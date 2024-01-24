package PROJECTPDB.MsRecepcion.Configuraciones;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import PROJECTPDB.MsRecepcion.models.RecepModels;
import PROJECTPDB.MsRecepcion.services.RecepService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RecepListener {

    @Autowired
    private RecepService service;

    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void consumerMensaje(ConsumerRecord<Integer, Integer> consumer){
        /*Map<String, Integer> jsonDocument = consumer.value();
        String msjJson = jsonDocument.get("msgeJSON").toString();
        Integer id_document = jsonDocument.get("idDocument");*/

        Integer id_document = consumer.value();
        log.info("------------------------------------", id_document);
        RecepModels entity = service.getRecepModels();

        if(entity.getId_document() == id_document){
            service.addRecepcion(entity);// entidad creada en la Base de datos
            service.willBeCreated('S');
        }else{
            service.willBeCreated('N');
        }
    }
    
}
