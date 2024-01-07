package PROJECTPDB.MsDocumentoExterno.models.DTO;

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
    private Integer id_Doc;
    private String nombreArchivo;
    private String codigoDocumento;
    private Date fechaRecepcion;
    private Boolean estadoDocumento;
    private String asuntoDocumento;
    private Integer numeroFolios;
    private String tipoDocumento;
    private Integer usuarioModificacion;  

}
