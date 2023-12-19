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




    

}
