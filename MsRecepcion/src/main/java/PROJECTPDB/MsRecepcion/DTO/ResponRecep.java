package PROJECTPDB.MsRecepcion.DTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponRecep {
    private Integer idRecep;
    private Integer idDocument;
    private String evaluacion;
    private Date fInicio;
    private Date fFin;
}
