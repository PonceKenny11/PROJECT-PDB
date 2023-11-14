package TDB.MSSeguridad.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import TDB.MSSeguridad.repository.microRepository;
import TDB.MSSeguridad.models.UsuarioModel;

@Service
public class microService {
    public microService(){
        
    }

    @Autowired
    microRepository _microRepository;

    public List<UsuarioModel> getAll(){
        return (List<UsuarioModel>) _microRepository.findAll();
    }

    /*aqui se colocaran los demas methods */

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
            usuario.setPassword(usuarioActualizado.getPassword());
            return _microRepository.save(usuario);
        }
        return null;
    }
}
