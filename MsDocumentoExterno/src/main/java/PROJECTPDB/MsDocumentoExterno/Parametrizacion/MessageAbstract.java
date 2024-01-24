package PROJECTPDB.MsDocumentoExterno.Parametrizacion;

public abstract class MessageAbstract {
    protected static final String MSG_EXCEP = "Error, Manejo de excepciones en document Externo => ";
    protected static final String MSG_CREATED = "El Documento Externo ha sido creado Exitosamente!";
    protected static final String MSG_DELETE = "El Documento Ha sido Eliminado Correctamente";
    protected static final String MSG_SERVER = "Error Interno en el Servidor, Intentelo mas tarde";
    protected static final String MSG_EMPTY = "Los campos para la creacion del Documento estan vacios!";
    protected static final String MSG_CORRECT = "Se Envio Correctamente a Recepcion";
    
    

    protected static String MsageUpdate(boolean resultado){
        return resultado ? "Este Documento Externo ha sido modificado ....": "No se puedo realizar Correctamente la modificación,  Intentelo de nuevo!";
    }; 

    protected static String MSG_EXIST(boolean resultado){
        return resultado ? "Hay un Documento existente con este id => ": "¡No Existe el documento externo!";
    }; 


}
