
package com.example.jpa.serviceImpl;

import com.example.jpa.entity.Categoria;
import com.example.jpa.repository.CategoriaRepository;
import com.example.jpa.service.CategoriaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Override
    public Categoria create(Categoria cat) {

        return categoriaRepository.save(cat);
    }

    @Override
    public Categoria update(Categoria cat) {

        return categoriaRepository.save(cat);
    }

    @Override
    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public Optional<Categoria> read(Long id) {

        return categoriaRepository.findById(id);
    }

    @Override
    public List<Categoria> readAll() {

        return categoriaRepository.findAll();
    }
    
}
