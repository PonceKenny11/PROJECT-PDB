package PROJECTPDB.MsRecepcion.Configuraciones;



public abstract class MessagesRecep {
    

    protected static final String MSG_ID = "No hay coincidencia de ID del documento enviado por kafka";
    protected static final String MSG_EXCEPTIONS = "Exceptions no manejadas => ";

    protected static final String FUNC_MSG_COMPLETED(int n){
        return n == 1 ? "El Object Recepcion tienes los datos completados": "Error => los campos estan vacios";
    }

    protected static final String FUNC_MSG_EXIST_DOC(int n){
        return n != 0 ? "El Documento ha sido recepcinado Correctamente ": "El documento asignado no coinciden, verefique la existencia del documento";
    }

}
