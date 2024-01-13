package TDB.MSSeguridad.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TDB.MSSeguridad.models.Entity.UsuarioModel;
import TDB.MSSeguridad.repository.microRepository;

@Service
public class microService {
    public microService(){
        
    }

    @Autowired
    microRepository _microRepository;

    public List<UsuarioModel> getAll(){
        return (List<UsuarioModel>) _microRepository.findAll();
    }


    public UsuarioModel obtenerUsuarioPorId(int id) {
        return _microRepository.findById(id).orElse(null);
    }

    public UsuarioModel crearUsuario(UsuarioModel usuario) {
        return _microRepository.save(usuario);
    }
    
    public void eliminarUsuario(int id) {
        _microRepository.deleteById(id);
    }

    public UsuarioModel actualizarUsuario(UsuarioModel usuarioActualizado) {
        UsuarioModel usuario = _microRepository.findById(usuarioActualizado.idUsuario).orElse(null);
        if (usuario != null) {
            usuario.setUsername(usuarioActualizado.getUsername());
            usuario.setCorreo(usuarioActualizado.getCorreo());
            usuario.setPassword(usuarioActualizado.getPassword());
            usuario.setFechaCreada(usuarioActualizado.getFechaCreada());
            return _microRepository.save(usuario);
        }
        return null;
    }

    public Boolean LoginIn(String correo_usuario, String password_usuario){
        List<UsuarioModel> userResult = (List<UsuarioModel>)_microRepository.findAll();
        List<UsuarioModel> userFiltro = userResult.stream().filter(user -> user.getCorreo().equals(correo_usuario) && user.getPassword().equals(password_usuario))
                                        .collect(Collectors.toList());

        if(userFiltro.isEmpty()){
            return false;
        }

        return true;
    }

    /*public UsuarioModel iniciarSesion(String correo_usuario, String password_usuario){
        return _microRepository.findByCorreoAndPassword(correo_usuario, password_usuario);
    }*/

}
