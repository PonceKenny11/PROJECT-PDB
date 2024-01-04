package TDB.MSSeguridad.models.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel {
    
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

  
    
}
