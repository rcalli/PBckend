
package com.example.jpa.service;

import com.example.jpa.entity.Categoria;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author USER
 */
public interface CategoriaService {
    public Categoria create(Categoria cat);
    public Categoria update(Categoria cat);
    public void delete(Long id);
    public Optional<Categoria> read(Long id);
    public List<Categoria> readAll();
}
