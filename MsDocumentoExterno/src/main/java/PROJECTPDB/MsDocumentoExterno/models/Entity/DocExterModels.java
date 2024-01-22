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
  // estos atributos deben ser idénticos a la bd
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_document;
    private String nombre_archivo;
    private String codigo_document;
    private Date fecha_emision;
    private Date fecha_recepcion;
    private String asunto_document;
    private String tipo_document;
    private Boolean estado_document;
    private Integer numero_folios;
    private Integer usuario_admin;

}
