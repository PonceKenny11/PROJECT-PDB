package PROJECTPDB.MsRecepcion.Configuraciones;

import PROJECTPDB.MsRecepcion.DTO.RequestRecep;


public abstract class metodosRecep {
        protected static char IsNo;
        public abstract void setRecepModels(RequestRecep reqRecepcion);
        public abstract Boolean getHasCreated();
}
