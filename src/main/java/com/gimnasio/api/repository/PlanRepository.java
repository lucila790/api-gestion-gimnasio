package com.gimnasio.api.repository;

import com.gimnasio.api.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

    List<Plan> findByActivoTrue();

    // Query nativa personalizada que busca planes por límite de precio máximo
    @Query(value = "SELECT * FROM planes WHERE precio <= :precioMax AND activo = 1", nativeQuery = true)
    List<Plan> findPlanesEconomicos(@Param("precioMax") Double precioMax);
}