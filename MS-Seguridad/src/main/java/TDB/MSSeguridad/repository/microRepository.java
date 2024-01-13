package TDB.MSSeguridad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import TDB.MSSeguridad.models.Entity.UsuarioModel;

@Repository
public interface microRepository  extends CrudRepository<UsuarioModel, Integer>{

   
} 