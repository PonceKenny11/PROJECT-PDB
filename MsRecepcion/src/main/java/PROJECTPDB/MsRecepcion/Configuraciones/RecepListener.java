package PROJECTPDB.MsRecepcion.Configuraciones;



import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import PROJECTPDB.MsRecepcion.models.RecepModels;
import PROJECTPDB.MsRecepcion.services.IRecepServicio;
import PROJECTPDB.MsRecepcion.services.RecepService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RecepListener {

    @Autowired
    private RecepService service;
  
    private IRecepServicio servicio2;

    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void consumerMensaje(ConsumerRecord<Integer, String> consumer){
        /*Map<String, Integer> jsonDocument = consumer.value();
        String msjJson = jsonDocument.get("msgeJSON").toString();
        Integer id_document = jsonDocument.get("idDocument");*/

        String idDocumentString = consumer.value().toString();
        Integer id_document = Integer.parseInt(idDocumentString);
        
        log.info("id traido del servicio DocumenExterno: {}", id_document);
        servicio2.setIdDocumentaso(id_document);
        RecepModels entity = servicio2.getRecepModels();
        log.info("id traido del servicio DocumenExterno: {}", entity);
        servicio2.setModelo(entity);
        if(entity.getId_document() == id_document){
            service.addRecepcion(entity);// entidad creada en la Base de datos
            servicio2.willBeCreated('S');
        }else{
            servicio2.willBeCreated('N');
        }
    }
    
}
