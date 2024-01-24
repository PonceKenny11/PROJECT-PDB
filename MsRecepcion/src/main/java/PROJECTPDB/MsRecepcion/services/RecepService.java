package PROJECTPDB.MsRecepcion.services;

import java.util.List;

import org.springframework.stereotype.Service;

import PROJECTPDB.MsRecepcion.Configuraciones.metodosRecep;
import PROJECTPDB.MsRecepcion.DTO.RequestRecep;
import PROJECTPDB.MsRecepcion.DTO.ResponRecep;
import PROJECTPDB.MsRecepcion.Mapper.RecepMapper;
import PROJECTPDB.MsRecepcion.models.RecepModels;
import PROJECTPDB.MsRecepcion.repository.RecepRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecepService extends metodosRecep{

   

    private final RecepRepository repository;
    private RecepModels EntityRecep;

    public void addRecepcion(RecepModels entity){
        repository.save(entity);
    }

    public List<RecepModels> getAccesAll() {
        return (List<RecepModels>) repository.findAll();
    }

    @Override 
    public void setRecepModels(RequestRecep reqRecepcion){
        EntityRecep = RecepMapper.mapToEntity(reqRecepcion);
    }

    @Override 
    public RecepModels getRecepModels(){
        return EntityRecep;
    }

    @Override
    public Boolean getHasCreated() {
        return IsNo;
    }

    @Override
    public void willBeCreated(char c) {
        IsNo = c == 'S' ? true : false;
        
    }
    

}
