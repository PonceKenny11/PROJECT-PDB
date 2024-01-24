package PROJECTPDB.MsRecepcion.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import PROJECTPDB.MsRecepcion.Configuraciones.metodosRecep;
import PROJECTPDB.MsRecepcion.DTO.RequestRecep;
import PROJECTPDB.MsRecepcion.Mapper.RecepMapper;
import PROJECTPDB.MsRecepcion.models.RecepModels;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class IRecepServicio extends metodosRecep{

    private RecepModels EntityRecep;

    private Integer idDocumentaso;


    @Override 
    public void setRecepModels(RequestRecep reqRecepcion){
        EntityRecep = RecepMapper.mapToEntity(reqRecepcion);
    }

    @Override 
    public RecepModels getRecepModels(){
        return EntityRecep;
    }

    public void setModelo(RecepModels EntityRecep){
        this.EntityRecep = EntityRecep;
    }

    @Override
    public Boolean getHasCreated() {
        return IsNo;
    }

    @Override
    public void willBeCreated(char c) {
        IsNo = c == 'S' ? true : false;
        
    }
    

    public Integer getIdDocumentaso() {
        return idDocumentaso;
    }

    public void setIdDocumentaso(Integer idDocumentaso) {
        this.idDocumentaso = idDocumentaso;
    }

}
