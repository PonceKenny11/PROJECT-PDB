package TDB.MSSeguridad.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TDB.MSSeguridad.models.Entity.UsuarioModel;
import TDB.MSSeguridad.parametrizacion.menssages;
import TDB.MSSeguridad.services.microService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class microController extends menssages{

    private final  microService servicio;


    @GetMapping
    public ResponseEntity<?> getAll() {

        try {
            List<UsuarioModel> usuarios = servicio.getAll();
            return new ResponseEntity<>(usuarios, HttpStatus.OK); // mostrar un mensaje exitoso 200k y la lista de
                                                                  // usuarios
        } catch (Exception e) {
            log.error(MSG_EXCETION, e);
            return new ResponseEntity<String>(MSG_SERVER, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUsuarioPorId(@PathVariable int id) {
        try {
            UsuarioModel usuario = servicio.obtenerUsuarioPorId(id);
            if (usuario != null) {
                log.info(MsageExist(true)+usuario.getUsername());
                return new ResponseEntity<>(usuario, HttpStatus.OK); // mostrar un mensaje exitoso 200
            } else {
                return new ResponseEntity<String>(MsageExist(false), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error(MSG_EXCETION, e);
            return new ResponseEntity<String>(MSG_SERVER, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable int id)throws Exception {
        servicio.eliminarUsuario(id);
        return new ResponseEntity<String>(MSG_DELETE, HttpStatus.ACCEPTED);
    }

    @PutMapping("/edit")
    public UsuarioModel actualizarUsuario(@RequestBody UsuarioModel usuarioActualizado) {
        return servicio.actualizarUsuario(usuarioActualizado);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@RequestBody UsuarioModel usuario) throws Exception{
        UsuarioModel user = servicio.crearUsuario(usuario);
        log.info(MSG_CREATED, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    // login
    @PostMapping("/login")
    public ResponseEntity<?> IniciarSesion(@RequestBody UsuarioModel usuario) {

        try {
            Boolean authentificar = servicio.LoginIn(usuario.getCorreo(), usuario.getPassword());
            log.info("Post: Username {} - Password {}", usuario.getUsername(), usuario.getPassword());
            if (authentificar == true) {
                return new ResponseEntity<String>(MsageLogin(true), HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<String>(MsageLogin(false), HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            // TODO: handle exception
            log.error(MSG_EXCETION, e);
            return new ResponseEntity<String>(MSG_SERVER, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
