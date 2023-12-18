package PROJECTPDB.MsDocumentoExterno.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Usuario_Admin")
public class DocExterModels {
    public DocExterModels(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    public int idUser;

    @Column(name="Nombre_user")    
    public String username;

    @Column(name="contraseña_user")
    public String pasword;

    @Column(name="correo_user")
    public String correo;

    @Column(name="fecha_creacion")
    public Date fechaCreada;


    public int getIdUser() {
        return this.idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasword() {
        return this.pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaCreada() {
        return this.fechaCreada;
    }

    public void setFechaCreada(Date fechaCreada) {
        this.fechaCreada = fechaCreada;
    }
    

}
