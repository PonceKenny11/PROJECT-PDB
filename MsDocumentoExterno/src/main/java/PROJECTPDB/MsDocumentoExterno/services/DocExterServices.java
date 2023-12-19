package PROJECTPDB.MsDocumentoExterno.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PROJECTPDB.MsDocumentoExterno.repository.DocExterRepository;

@Service
public class DocExterServices {
    public DocExterServices(){

    }
    
    @Autowired
    DocExterRepository _DocExterRepository;
    
    
}
