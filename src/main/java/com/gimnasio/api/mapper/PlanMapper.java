package com.gimnasio.api.mapper;

import com.gimnasio.api.dto.plan.PlanRequest;
import com.gimnasio.api.dto.plan.PlanResponse;
import com.gimnasio.api.entity.Plan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @org.mapstruct.Builder(disableBuilder = true))
public interface PlanMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "miembros", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    Plan toEntity(PlanRequest request);

    PlanResponse toResponse(Plan plan);
}