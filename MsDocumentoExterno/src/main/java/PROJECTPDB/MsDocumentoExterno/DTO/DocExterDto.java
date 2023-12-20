package PROJECTPDB.MsDocumentoExterno.DTO;

import java.sql.Date;

public class DocExterDto {
    private int id;
    private String mombreArchivo;
    private String CodigoDocumento;
    private String AsuntoDocumento;
    private Date fechaEmision;
    private int numeroFolios;
    private String TipoDocumento;



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

     public String getMombreArchivo() {
        return mombreArchivo;
    }
    public void setMombreArchivo(String mombreArchivo) {
        this.mombreArchivo = mombreArchivo;
    }

    public String getCodigoDocumento() {
        return CodigoDocumento;
    }
    public void setCodigoDocumento(String codigoDocumento) {
        CodigoDocumento = codigoDocumento;
    }
    public String getAsuntoDocumento() {
        return AsuntoDocumento;
    }
    public void setAsuntoDocumento(String asuntoDocumento) {
        AsuntoDocumento = asuntoDocumento;
    }
    public Date getFechaEmision() {
        return fechaEmision;
    }
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    public int getNumeroFolios() {
        return numeroFolios;
    }
    public void setNumeroFolios(int numeroFolios) {
        this.numeroFolios = numeroFolios;
    }
    public String getTipoDocumento() {
        return TipoDocumento;
    }
    public void setTipoDocumento(String tipoDocumento) {
        TipoDocumento = tipoDocumento;
    }

    


    

}
