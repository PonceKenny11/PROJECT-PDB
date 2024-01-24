package PROJECTPDB.MsRecepcion.services;

import java.util.List;

import org.springframework.stereotype.Service;


import PROJECTPDB.MsRecepcion.models.RecepModels;
import PROJECTPDB.MsRecepcion.repository.RecepRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecepService{

   
    private final RecepRepository repository;
    
    
    public void addRecepcion(RecepModels entity){
        repository.save(entity);
    }

    public List<RecepModels> getAccesAll() {
        return (List<RecepModels>) repository.findAll();
    }

    

}
