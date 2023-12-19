package PROJECTPDB.MsDocumentoExterno.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;  // Importa la clase LoggerFactory
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PROJECTPDB.MsDocumentoExterno.models.DocExterModels;
import PROJECTPDB.MsDocumentoExterno.services.DocExterServices;

@RestController
@RequestMapping("/api/documentos")
public class DocExterController {
    
    // Declara una instancia de Logger
    private static final Logger log = LoggerFactory.getLogger(DocExterController.class);

    @Autowired
    private DocExterServices docExterServices;

    @PostMapping("/crear")
    public ResponseEntity<?> crearDocumento(@RequestBody DocExterModels documento) {
        try {
            DocExterModels nuevoDocumento = docExterServices.crearDoc(documento);
            return new ResponseEntity<>(nuevoDocumento, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception for developer
            log.error("Error al crear el documento", e);

            // Return a user-friendly error message
            return new ResponseEntity<>("No se pudo crear el documento. Por favor, inténtelo de nuevo más tarde.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

