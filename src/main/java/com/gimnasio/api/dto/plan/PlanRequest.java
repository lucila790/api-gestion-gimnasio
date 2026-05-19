package com.gimnasio.api.dto.plan;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PlanRequest {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 255)
    private String nombre;

    private String descripcion;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser un número positivo")
    private Double precio;

    @NotNull(message = "La duración en meses es obligatoria")
    @Min(value = 1, message = "La duración mínima es de 1 mes")
    private Integer duracionMeses;

    private Integer numeroSesionesSemanales;
}