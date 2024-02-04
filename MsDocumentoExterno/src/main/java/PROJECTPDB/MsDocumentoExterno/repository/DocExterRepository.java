package PROJECTPDB.MsDocumentoExterno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import PROJECTPDB.MsDocumentoExterno.models.Entity.DocExterModels;

@Repository
public interface DocExterRepository extends JpaRepository<DocExterModels, Integer> {


}
