package PROJECTPDB.MsDocumentoExterno.DTO;

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
    private String AsuntoDocumento;
    private String TipoDocumento;
    private Boolean EstadoDocumento;
    private Integer NumeroFolios;
    private Integer UsuarioModificacion;   
}
