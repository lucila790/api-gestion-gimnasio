package com.gimnasio.api.dto.plan;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PlanResponse {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer duracionMeses;
    private Integer numeroSesionesSemanales;
    private Boolean activo;
    private LocalDateTime fechaCreacion;
}