package PROJECTPDB.MsDocumentoExterno.models.DTO;

import PROJECTPDB.MsDocumentoExterno.models.Entity.DocExterModels;

public class DocMapper {

    /*
     * public static DocExterModels mapToDocEntity(DocumentRequest documentRequest)
     * {
     * return _modelMapper.map(documentRequest, DocExterModels.class);
     * }
     */
    public static DocumentResponse mapToDocResponse(DocExterModels docEntity) {
        var docResponse = DocumentResponse.builder().id_Doc(docEntity.getId_docext())
                .nombreArchivo(docEntity.getNombre_archivo())
                .codigoDocumento(docEntity.getCodigo_documento())
                .asuntoDocumento(docEntity.getAsunto_doc())
                .fechaRecepcion(docEntity.getFecha_recepcion())
                .estadoDocumento(docEntity.getEstado_doc())
                .numeroFolios(docEntity.getNumero_folio())
                .tipoDocumento(docEntity.getTipo_documento())
                .usuarioModificacion(docEntity.getUser_update())
                .build();
        return docResponse;
    }

    public static DocExterModels mapToDocEntity(DocumentRequest documentRequest) {
        var documentEntity = DocExterModels.builder().nombre_archivo(documentRequest.getNombreArchivo())
                .codigo_documento(documentRequest.getCodigoDocumento())
                .fecha_emision(documentRequest.getFechaEmision())
                .fecha_recepcion(documentRequest.getFechaRecepcion())
                .estado_doc(documentRequest.getEstadoDocumento())
                .asunto_doc(documentRequest.getAsuntoDocumento())
                .numero_folio(documentRequest.getNumeroFolios())
                .tipo_documento(documentRequest.getTipoDocumento())
                .user_update(documentRequest.getUsuarioModificacion())
                .build();
        return documentEntity;
    }

}
