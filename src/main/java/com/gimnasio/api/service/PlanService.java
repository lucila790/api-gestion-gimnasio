package com.gimnasio.api.service;

import com.gimnasio.api.dto.plan.PlanRequest;
import com.gimnasio.api.dto.plan.PlanResponse;
import com.gimnasio.api.entity.Plan;
import com.gimnasio.api.mapper.PlanMapper;
import com.gimnasio.api.repository.PlanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanService {

    private final PlanRepository planRepository;
    private final PlanMapper planMapper;

    public PlanService(PlanRepository planRepository, PlanMapper planMapper) {
        this.planRepository = planRepository;
        this.planMapper = planMapper;
    }

    @Transactional(readOnly = true)
    public List<PlanResponse> obtenerTodos() {
        return planRepository.findAll().stream()
                .map(planMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PlanResponse> obtenerEconomicos(Double precioMax) {
        return planRepository.findPlanesEconomicos(precioMax).stream()
                .map(planMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public PlanResponse guardar(PlanRequest request) {
        Plan plan = planMapper.toEntity(request);
        plan.setActivo(true);
        return planMapper.toResponse(planRepository.save(plan));
    }

    @Transactional
    public PlanResponse actualizar(Long id, PlanRequest request) {
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El plan solicitado no existe"));

        plan.setNombre(request.getNombre());
        plan.setDescripcion(request.getDescripcion());
        plan.setPrecio(request.getPrecio());
        plan.setDuracionMeses(request.getDuracionMeses());
        plan.setNumeroSesionesSemanales(request.getNumeroSesionesSemanales());

        return planMapper.toResponse(planRepository.save(plan));
    }

    @Transactional
    public void eliminar(Long id) {
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El plan solicitado no existe"));
        planRepository.delete(plan);
    }
}