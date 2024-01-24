package PROJECTPDB.MsRecepcion.Configuraciones;

import PROJECTPDB.MsRecepcion.DTO.RequestRecep;
import PROJECTPDB.MsRecepcion.models.RecepModels;

public abstract class metodosRecep {
        protected static Boolean IsNo;
        public abstract RecepModels getRecepModels();
        public abstract void setRecepModels(RequestRecep reqRecepcion);
        public abstract Boolean getHasCreated();
        public abstract void willBeCreated(char c);
}
