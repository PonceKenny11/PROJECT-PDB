package TDB.MSSeguridad.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="usuarios")
public class UsuarioModel {
    
    public UsuarioModel(){ 

        
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuarios")
    public int idUsuario;

    @Column(name="name_user")    
    public String username;

    @Column(name="correo_user")
    public String correo;

    @Column(name="pass_user")
    public String password;

    @Column(name="fecha_creacion")
    public Date fechaCreada;

    //////////////////////////////////////////
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //////////////////////
    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setFechaCreada(Date fechaCreada) {
        this.fechaCreada = fechaCreada;
    
    }

    public Date getFechaCreada(){
        return this.fechaCreada;
    } 
    
}
