package PROJECTPDB.MsRecepcion.Configuraciones;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import PROJECTPDB.MsRecepcion.models.RecepModels;
import PROJECTPDB.MsRecepcion.services.RecepService;

public class RecepListener {

    @Autowired
    private RecepService service;

    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void consumerMensaje(ConsumerRecord<Integer, Map<String, Integer>> consumer){
        Map<String, Integer> jsonDocument = consumer.value();
        String msjJson = jsonDocument.get("msgeJSON").toString();
        Integer id_document = jsonDocument.get("idDocument");

        RecepModels entity = service.getRecepModels();

        if(entity.getId_document() == id_document){
            service.addRecepcion(entity);// entidad creada en la Base de datos
            service.willBeCreated('S');
        }else{
            service.willBeCreated('N');
        }
    }
    
}
