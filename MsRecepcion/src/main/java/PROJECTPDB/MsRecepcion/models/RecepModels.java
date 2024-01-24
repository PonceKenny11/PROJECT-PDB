package PROJECTPDB.MsRecepcion.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "tbc_Recepcion")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@NonNull
public class RecepModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_recepcion;
    private Integer id_document;
    private String detalle_evaluar;
    private Date f_ini_evaluar;
    private Date f_fin_evaluar;
}
