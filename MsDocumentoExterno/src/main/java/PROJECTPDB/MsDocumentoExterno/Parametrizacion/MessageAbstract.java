package PROJECTPDB.MsDocumentoExterno.Parametrizacion;

public abstract class MessageAbstract {
    protected static final String MSG_EX = "Error, Manejo de excepciones en document Externo ->";
    protected static final String MSG_CREATED = "El Documento Externo ha sido creado Exitosamente!";
    protected static final String MSG_DELETE = "El Documento Ha sido Eliminado Correctamente";
    protected static final String MSG_SERVER = "Error Interno en el Servidor, Intentelo mas tarde";
    protected static final String MSG_EXIST = "No existe el Documento Externo!...";
    

    protected static String MsageUpdate(boolean resultado){
        if (resultado) {
            return "Este Documento Externo ha sido modificado ....";
        }else{
            return "No se puedo realizar Correctamente la modificación,  Intentelo de nuevo!";
        }
    }; 

    

}
