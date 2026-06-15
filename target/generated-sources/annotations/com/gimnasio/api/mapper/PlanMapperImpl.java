package com.gimnasio.api.mapper;

import com.gimnasio.api.dto.plan.PlanRequest;
import com.gimnasio.api.dto.plan.PlanResponse;
import com.gimnasio.api.entity.Plan;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-15T15:10:36-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class PlanMapperImpl implements PlanMapper {

    @Override
    public Plan toEntity(PlanRequest request) {
        if ( request == null ) {
            return null;
        }

        Plan plan = new Plan();

        plan.setDescripcion( request.getDescripcion() );
        plan.setDuracionMeses( request.getDuracionMeses() );
        plan.setNombre( request.getNombre() );
        plan.setNumeroSesionesSemanales( request.getNumeroSesionesSemanales() );
        plan.setPrecio( request.getPrecio() );

        return plan;
    }

    @Override
    public PlanResponse toResponse(Plan plan) {
        if ( plan == null ) {
            return null;
        }

        PlanResponse planResponse = new PlanResponse();

        planResponse.setActivo( plan.getActivo() );
        planResponse.setDescripcion( plan.getDescripcion() );
        planResponse.setDuracionMeses( plan.getDuracionMeses() );
        planResponse.setFechaCreacion( plan.getFechaCreacion() );
        planResponse.setId( plan.getId() );
        planResponse.setNombre( plan.getNombre() );
        planResponse.setNumeroSesionesSemanales( plan.getNumeroSesionesSemanales() );
        planResponse.setPrecio( plan.getPrecio() );

        return planResponse;
    }
}
