package com.gimnasio.api.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "miembros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Miembro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String telephone; // Mapeado a la columna telefono

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false)
    private Integer edad;

    private String sexo;

    @Column(name = "peso_actual")
    private Double pesoActual;

    private Double altura;
    private Double imc;

    @Column(nullable = false)
    private String estado = "ACTIVO";

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "miembro_plan", joinColumns = @JoinColumn(name = "miembro_id"), inverseJoinColumns = @JoinColumn(name = "plan_id"))
    private Set<Plan> planes = new HashSet<>();
}