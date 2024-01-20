package TDB.MSSeguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TDB.MSSeguridad.models.UsuarioModel;

@Repository
public interface UserRepository  extends JpaRepository<UsuarioModel, Integer>{

   
} 