package PROJECTPDB.MsDocumentoExterno.DTO;
import PROJECTPDB.MsDocumentoExterno.models.DocExterModels;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface DocExterMapper {
    DocExterMapper INSTANCE = Mappers.getMapper(DocExterMapper.class);

    @Mappings({
        @Mapping(source = "id", target = "IdDocExt"),
        @Mapping(source = "NombreArchivo", target = "NombreArchivo"),
        @Mapping(source = "CodigoDocumento", target = "CodigoDocumento"),
        @Mapping(source = "fechaEmision", target = "FechaEmision"),
        @Mapping(source = "numeroFolios", target = "NumeroFolio"),
        @Mapping(source = "TipoDocumento", target = "TipoDocumento")
    })
    DocExterDto functConverToDto(DocExterModels documentoModel);
}
