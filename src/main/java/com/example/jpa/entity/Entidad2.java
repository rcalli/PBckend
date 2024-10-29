
package com.example.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

/**
 *
 * @author USER
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "nombre")
public class Entidad2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "estado")
    private char estado = '1';
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "categoria")
    @JsonIgnore
    private Set<Producto> productos;
}
