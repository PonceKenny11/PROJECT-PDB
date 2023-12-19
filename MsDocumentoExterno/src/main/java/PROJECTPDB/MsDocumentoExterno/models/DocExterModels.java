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
    @Column(name="id_doc_ext")
    public int IdDocExt;

    @Column(name="nombre_archivo")    
    public String NombreArchivo;

    @Column(name="codigo_documento")
    public String CodigoDocumento;

    @Column(name="fecha_emision")
    public Date FechaEmision;

    @Column(name="fecha_recepcion")
    public Date FechaRecepcion;

     @Column(name="asunto_doc")    
    public String AsuntoDoc;

     @Column(name="estado_doc")    
    public Boolean EstadoDoc;

     @Column(name="numero_folio")    
    public int NumeroFolio;

     @Column(name="tipo_documento")    
    public String TipoDocumento;

     @Column(name="usuario_modificacion")    
    public int UsuarioModificacion;

     @Column(name="id_recepcion_ext")    
    public int IdRecepcionExt;



    public int getIdDocExt() {
        return this.IdDocExt;
    }

    public void setIdDocExt(int IdDocExt) {
        this.IdDocExt = IdDocExt;
    }

    public String getNombreArchivo() {
        return this.NombreArchivo;
    }

    public void setNombreArchivo(String NombreArchivo) {
        this.NombreArchivo = NombreArchivo;
    }

    public String getCodigoDocumento() {
        return this.CodigoDocumento;
    }

    public void setCodigoDocumento(String CodigoDocumento) {
        this.CodigoDocumento = CodigoDocumento;
    }

    public Date getFechaEmision() {
        return this.FechaEmision;
    }

    public void setFechaEmision(Date FechaEmision) {
        this.FechaEmision = FechaEmision;
    }

    public Date getFechaRecepcion() {
        return this.FechaRecepcion;
    }

    public void setFechaRecepcion(Date FechaRecepcion) {
        this.FechaRecepcion = FechaRecepcion;
    }

    public String getAsuntoDoc() {
        return this.AsuntoDoc;
    }

    public void setAsuntoDoc(String AsuntoDoc) {
        this.AsuntoDoc = AsuntoDoc;
    }

    public Boolean isEstadoDoc() {
        return this.EstadoDoc;
    }

    public Boolean getEstadoDoc() {
        return this.EstadoDoc;
    }

    public void setEstadoDoc(Boolean EstadoDoc) {
        this.EstadoDoc = EstadoDoc;
    }

    public int getNumeroFolio() {
        return this.NumeroFolio;
    }

    public void setNumeroFolio(int NumeroFolio) {
        this.NumeroFolio = NumeroFolio;
    }

    public String getTipoDocumento() {
        return this.TipoDocumento;
    }

    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    public int getUsuarioModificacion() {
        return this.UsuarioModificacion;
    }

    public void setUsuarioModificacion(int UsuarioModificacion) {
        this.UsuarioModificacion = UsuarioModificacion;
    }

    public int getIdRecepcionExt() {
        return this.IdRecepcionExt;
    }

    public void setIdRecepcionExt(int IdRecepcionExt) {
        this.IdRecepcionExt = IdRecepcionExt;
    }


    

}
