package com.gimnasio.api.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "planes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Plan extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    private String descripcion;

    @Column(nullable = false)
    private Double precio;

    @Column(name = "duracion_meses", nullable = false)
    private Integer duracionMeses;

    @Column(name = "numero_sesiones_semanales")
    private Integer numeroSesionesSemanales;

    @Column(nullable = false)
    private Boolean activo = true;

    @ManyToMany(mappedBy = "planes", fetch = FetchType.LAZY)
    private Set<Miembro> miembros = new HashSet<>();
}