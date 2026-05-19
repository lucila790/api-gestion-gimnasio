package com.gimnasio.api.controller;

import com.gimnasio.api.dto.plan.PlanRequest;
import com.gimnasio.api.dto.plan.PlanResponse;
import com.gimnasio.api.service.PlanService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/planes")
@CrossOrigin(origins = "*")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping
    public ResponseEntity<List<PlanResponse>> listarTodos() {
        return ResponseEntity.ok(planService.obtenerTodos());
    }

    // Uso de Query Params: /api/planes/filtrar?precioMax=20000
    @GetMapping("/filtrar")
    public ResponseEntity<List<PlanResponse>> listarEconomicos(@RequestParam Double precioMax) {
        return ResponseEntity.ok(planService.obtenerEconomicos(precioMax));
    }

    @PostMapping
    public ResponseEntity<PlanResponse> registrar(@Valid @RequestBody PlanRequest request) {
        return new ResponseEntity<>(planService.guardar(request), HttpStatus.CREATED);
    }

    // Uso de Path Variables: /api/planes/1
    @PutMapping("/{id}")
    public ResponseEntity<PlanResponse> modificar(@PathVariable Long id, @Valid @RequestBody PlanRequest request) {
        return ResponseEntity.ok(planService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        planService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}