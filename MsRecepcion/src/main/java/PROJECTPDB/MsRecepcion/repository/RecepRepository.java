package PROJECTPDB.MsRecepcion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import PROJECTPDB.MsRecepcion.models.RecepModels;

public interface RecepRepository extends JpaRepository<RecepModels, Integer>{
    
}
