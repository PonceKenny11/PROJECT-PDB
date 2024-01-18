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

    // estos atributos deben ser idénticos a la bd
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

}
