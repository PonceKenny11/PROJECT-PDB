package TDB.MSSeguridad.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TDB.MSSeguridad.services.microService;
import TDB.MSSeguridad.models.UsuarioModel;

@RestController
@RequestMapping("/api/auth")
public class microController {
    @Autowired
    microService _MicroService;
    
    @GetMapping
    public  List<UsuarioModel> getAll(){
        return _MicroService.getAll();
    }

    
   
}
