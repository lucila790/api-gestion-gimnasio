package com.gimnasio.api.service;

import com.gimnasio.api.dto.plan.PlanRequest;
import com.gimnasio.api.dto.plan.PlanResponse;
import com.gimnasio.api.entity.Plan;
import com.gimnasio.api.mapper.PlanMapper;
import com.gimnasio.api.repository.PlanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlanServiceTest {

    @Mock
    private PlanRepository planRepository;

    @Mock
    private PlanMapper planMapper;

    @InjectMocks
    private PlanService planService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGuardarPlanExitoso() {
        PlanRequest request = new PlanRequest();
        request.setNombre("Test Plan");

        Plan planMock = new Plan();
        planMock.setId(1L);
        planMock.setNombre("Test Plan");

        PlanResponse responseMock = new PlanResponse();
        responseMock.setId(1L);
        responseMock.setNombre("Test Plan");

        when(planMapper.toEntity(request)).thenReturn(planMock);
        when(planRepository.save(planMock)).thenReturn(planMock);
        when(planMapper.toResponse(planMock)).thenReturn(responseMock);

        PlanResponse resultado = planService.guardar(request);

        assertNotNull(resultado);
        assertEquals("Test Plan", resultado.getNombre());

        verify(planMapper, times(1)).toEntity(request);
        verify(planRepository, times(1)).save(planMock);
    }
}