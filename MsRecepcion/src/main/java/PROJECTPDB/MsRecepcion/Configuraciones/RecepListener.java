package PROJECTPDB.MsRecepcion.Configuraciones;



import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import PROJECTPDB.MsRecepcion.DTO.RequestRecep;
import PROJECTPDB.MsRecepcion.Mapper.RecepMapper;
import PROJECTPDB.MsRecepcion.models.RecepModels;

import PROJECTPDB.MsRecepcion.services.RecepService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RecepListener extends metodosRecep{


    private RecepModels EntityRecep;

    @Autowired
    private RecepService service;
  
 
    public RecepListener() {
    }


    @Override 
    public void setRecepModels(RequestRecep reqRecepcion){
        EntityRecep = RecepMapper.mapToEntity(reqRecepcion);
    }


    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void consumerMensaje(ConsumerRecord<Integer, String> consumer)throws JsonMappingException, JsonProcessingException {
        /*Map<String, Integer> jsonDocument = consumer.value();
        String msjJson = jsonDocument.get("msgeJSON").toString();
        Integer id_document = jsonDocument.get("idDocument");*/
        String idDocumentString = consumer.value().toString();
        Integer id_document = Integer.parseInt(idDocumentString);
        
        log.info("id traido del servicio DocumenExterno: {}", id_document);
   
        
        log.info("id traido del servicio DocumenExterno: {}", EntityRecep);

       
        if(EntityRecep.getId_document() == id_document){
            service.addRecepcion(EntityRecep);// entidad creada en la Base de datos
            IsNo = 'S';
        }else{
            IsNo = 'N';
        }
    }


    public void setModelo(RecepModels EntityRecep){
        this.EntityRecep = EntityRecep;
    }

    @Override
    public Boolean getHasCreated() {
        return IsNo == 'S' ? true : false; 
    }

    public RecepModels getObtienesModelo(){
        return EntityRecep;
    }
}
