package TDB.MSSeguridad.parametrizacion;

public abstract class menssages {
    protected static final String MSG_EXCETION = "Error, Manejo de excepciones en servicio Seguridad ->";
    protected static final String MSG_CREATED = "cuenta usuario creado Exitosamente!";
    protected static final String MSG_DELETE = "la cuenta usuario ha sido eliminado Correctamente";
    protected static final String MSG_SERVER = "Error Interno en el Servidor, Intentelo mas tarde";

    protected static final Long TOKEN_ONE_DAY_VALIDATION = 24L * 60 * 60;
    protected static final Long MILISEGUNDOS = 1000L;

    protected static String MsageUpdate(boolean resultado){
        if (resultado) {
            return "Tu cuenta Usuario ha sido modificado correctamente";
        }else{
            return "No se puedo realizar Correctamente la modificación,  Intentelo de nuevo!";
        }
    }; 

    protected static String MsageExist(boolean resultado){
        if (resultado) {
            return "Usuario disponible ....";
        }else{
            return "No existe este usuario o ha sido eliminado";
        }
    }; 

    protected static String MsageLogin(boolean resultado){
        if (resultado) {
            return "Usuario Authentificado! => ";
        }else{
            return "Las Credenciales son Incorrectas, Intentelo de nuevo...!";
        }
    };


}
