package TDB.MSSeguridad.dto;
import java.io.Serializable;

public class microResponse implements Serializable{
    private static final long serialVersionUID = 1L;
    private final String userName;

    //constructor
    public microResponse(String userName) {
        this.userName = userName;    
    }

    //method to
    public String getUserName() {
        return userName;
    }
}
