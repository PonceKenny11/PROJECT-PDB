package PROJECTPDB.MsDocumentoExterno.models.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_docexterno")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocExterModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //estos atributos deben ser idénticos a la bd 
    private Integer id_docext;
    private String nombre_archivo;
    private String codigo_documento;
    private Date fecha_emision;
    private Date fecha_recepcion;
    private String asunto_doc;
    private Boolean estado_doc;
    private Integer numero_folio;
    private String tipo_documento;
    private Integer user_update;
    /*@Column(name="id_docext")
    public Integer IdDocExt;

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
    public Integer NumeroFolio;

     @Column(name="tipo_documento")    
    public String TipoDocumento;

     @Column(name="user_update")    
    public Integer UsuarioModificacion;*/


}
