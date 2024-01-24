package PROJECTPDB.MsRecepcion.Mapper;

import PROJECTPDB.MsRecepcion.DTO.RequestRecep;
import PROJECTPDB.MsRecepcion.models.RecepModels;

public class RecepMapper {
    
    public static RecepModels mapToEntity(RequestRecep reqRecep){
        var RecepEntity = RecepModels.builder()
                            .id_document(reqRecep.getIdDocument())
                            .detalle_evaluar(reqRecep.getEvaluacion())
                            .fIni_evaluar(reqRecep.getFInicio())
                            .fFin_evaluar(reqRecep.getFFin())
                            .build();
        return RecepEntity;
    }
}
