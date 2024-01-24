package PROJECTPDB.MsRecepcion.Mapper;

import PROJECTPDB.MsRecepcion.DTO.RequestRecep;
import PROJECTPDB.MsRecepcion.models.RecepModels;

public class RecepMapper {
    
    public static RecepModels mapToEntity(RequestRecep reqRecep){
        var RecepEntity = RecepModels.builder()
                            .id_document(reqRecep.getIdDocument())
                            .detalle_evaluar(reqRecep.getEvaluacion())
                            .f_ini_evaluar(reqRecep.getFechaInicio())
                            .f_fin_evaluar(reqRecep.getFechaFin())
                            .build();
        return RecepEntity;
    }
}
