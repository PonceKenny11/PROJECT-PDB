package PROJECTPDB.MsDocumentoExterno.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import PROJECTPDB.MsDocumentoExterno.models.DocExterModels;

@Repository
public interface DocExterRepository extends CrudRepository<DocExterModels, Long> {

    DocExterModels findByCorreoAndPassword(String correo, String password);

}
