
package com.example.jpa.controller;


import com.example.jpa.entity.Categoria;
import com.example.jpa.service.CategoriaService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


/**
 *
 * @author USER
 */
@RestController // controller y responsebody, es para RESTful web services y para una apicacion de REST API
//http://localhost:8080/inventario-app
@RequestMapping("inventario-app")//en el postman seria algo asi http://localhost:8080/inventario-app/edit/1

@CrossOrigin(value="http://localhost:4200")

public class EntidadController {
    private static final Logger logger =
            LoggerFactory.getLogger(Categoria.class);

    @Autowired
    private CategoriaService catService;

    //http://locahost:8080/inventario-app/productos
    @GetMapping("/productos")
    public List<Categoria> obtenerProductos(){
        List<Categoria> productos = this.catService.readAll();
        logger.info("Productos obtenidos:");
        productos.forEach((producto -> logger.info(producto.toString())));
        return productos;
    }

}
