package TDB.MSSeguridad.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TDB.MSSeguridad.services.microService;
import TDB.MSSeguridad.models.UsuarioModel;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/auth")
public class microController {
    @Autowired
    microService _MicroService;
    private String msjDev;

    @GetMapping
    public ResponseEntity<?> getAll() {

        try {
            List<UsuarioModel> usuarios = _MicroService.getAll();
            return new ResponseEntity<>(usuarios, HttpStatus.OK); // mostrar un mensaje exitoso 200k y la lista de
                                                                  // usuarios
        } catch (Exception e) {
            msjDev = "Excepcion no manejada, no se pudo obtener lista de usuarios" + e.getMessage();
            return new ResponseEntity<>(msjDev, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUsuarioPorId(@PathVariable int id) {
        try {
            UsuarioModel usuario = _MicroService.obtenerUsuarioPorId(id);
            if (usuario != null) {
                return new ResponseEntity<>(usuario, HttpStatus.OK); // mostrar un mensaje exitoso 200
            } else {
                msjDev = "El usuario No existe";
                return new ResponseEntity<>(msjDev, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            msjDev = "Excepcion no manejada => " + e.getMessage();
            return new ResponseEntity<>(msjDev, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id) {
        _MicroService.eliminarUsuario(id);
    }

    @PutMapping("/editar")
    public UsuarioModel actualizarUsuario(@RequestBody UsuarioModel usuarioActualizado) {
        return _MicroService.actualizarUsuario(usuarioActualizado);
    }

    @PostMapping
    public UsuarioModel crearUsuario(@RequestBody UsuarioModel usuario) {
        return _MicroService.crearUsuario(usuario);
    }

    // login
    @PostMapping("/login")
    public ResponseEntity<?> IniciarSesion(@RequestBody UsuarioModel usuario) {

        try {
            UsuarioModel userAuth = _MicroService.iniciarSesion(usuario.getCorreo(), usuario.getPassword());

            if (userAuth != null) {
                return new ResponseEntity<>("Inicio de Sesion Exitotoso", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Las Credenciales son Incorrectas", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            // TODO: handle exception
            msjDev = "Excepcion de Iniciar Sesion ..." + e.getMessage();
            
            return new ResponseEntity<>(msjDev, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
