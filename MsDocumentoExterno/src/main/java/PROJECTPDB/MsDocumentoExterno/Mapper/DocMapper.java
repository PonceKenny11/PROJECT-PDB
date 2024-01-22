package PROJECTPDB.MsDocumentoExterno.Mapper;

import PROJECTPDB.MsDocumentoExterno.DTO.DocumentRequest;
import PROJECTPDB.MsDocumentoExterno.DTO.DocumentResponse;
import PROJECTPDB.MsDocumentoExterno.models.Entity.DocExterModels;

public class DocMapper {

    /*
     * public static DocExterModels mapToDocEntity(DocumentRequest documentRequest)
     * {
     * return _modelMapper.map(documentRequest, DocExterModels.class);
     * }
     */
    public static DocumentResponse mapToDocResponse(DocExterModels docEntity) { // SALIDA de entity a response
        var docResponse = DocumentResponse.builder()
                .nombreArchivo(docEntity.getNombre_archivo())
                .codigoDocumento(docEntity.getCodigo_document())
                .fechaEmision(docEntity.getFecha_emision())
                .fechaRecepcion(docEntity.getFecha_recepcion())
                .asuntoDocumento(docEntity.getAsunto_document())
                .tipoDocumento(docEntity.getTipo_document())
                .estadoDocumento(docEntity.getEstado_document())
                .numeroFolios(docEntity.getNumero_folios())
                .usuarioModificacion(docEntity.getUsuario_admin())
                .build();
        return docResponse;
    }

    public static DocExterModels mapToDocEntity(DocumentRequest documentRequest) { //entrada de request a Entity
        var documentEntity = DocExterModels.builder()
                .nombre_archivo(documentRequest.getNombreArchivo())
                .codigo_document(documentRequest.getCodigoDocumento())
                .fecha_emision(documentRequest.getFechaEmision())
                .fecha_recepcion(documentRequest.getFechaRecepcion())
                .asunto_document(documentRequest.getAsuntoDocumento())
                .tipo_document(documentRequest.getTipoDocumento())
                .numero_folios(documentRequest.getNumeroFolios())
                .usuario_admin(documentRequest.getUsuarioModificacion())
                .build();
        return documentEntity;
    }

}
