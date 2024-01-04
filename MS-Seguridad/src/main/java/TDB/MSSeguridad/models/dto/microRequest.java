package TDB.MSSeguridad.models.dto;

import java.io.Serializable;
public class microRequest  implements Serializable{

    private static final long serialVersionUID = 1L;
    private String usuario;
    private String clave;
 
    //constructor
    public microRequest() {
 
    }
 
    public microRequest(String usuario, String clave) {
        this.setUsuario(usuario);
        this.setClave(clave);
    }
 
    //method
    public String getClave() {
        return clave;
    }
 
    public void setClave(String clave) {
        this.clave = clave;
    }
 
    public String getUsuario() {
        return usuario;
    }
 
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}
