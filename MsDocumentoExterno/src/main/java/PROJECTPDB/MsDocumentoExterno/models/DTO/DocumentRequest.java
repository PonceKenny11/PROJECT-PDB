package PROJECTPDB.MsDocumentoExterno.models.DTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentRequest {
    private Integer IdDoc;
    private String NombreArchivo;
    private String CodigoDocumento;
    private Date FechaEmision;
    private Date FechaRecepcion;
    private Boolean EstadoDocumento;
    private String AsuntoDocumento;
    private Integer NumeroFolios;
    private String TipoDocumento;
    private Integer UsuarioModificacion;   
}
