package PROJECTPDB.MsDocumentoExterno.DTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentResponse {
    private String nombreArchivo;
    private String codigoDocumento;
    private Date fechaEmision;
    private Date fechaRecepcion;
    private String asuntoDocumento;
    private String tipoDocumento;
    private Boolean estadoDocumento;
    private Integer numeroFolios;
    private Integer usuarioModificacion;
}
//probandoooooooooo
