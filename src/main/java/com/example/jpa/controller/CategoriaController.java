
package com.example.jpa.controller;


import com.example.jpa.entity.Categoria;
import com.example.jpa.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 *
 * @author USER
 */
@Controller
public class CategoriaController {
    @Autowired
    private CategoriaService catService;
    
    @GetMapping
    public String index(Model model){
        model.addAttribute("categorias", catService.readAll());
        return "index";
    }
    
    @GetMapping("/add")
    public String addPost(Model model){
        Categoria cat = new Categoria();
        model.addAttribute("categoria", cat);
        return "add";
    }
    
    
    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable("id") Long id, Model model){
        model.addAttribute("categoria", catService.read(id).get());
        return "edit";
    }
    
    @GetMapping("/del/{id}")
    public String delPost(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes){
        catService.delete(id);
        redirectAttributes.addFlashAttribute("flashMessage", "Categoria deleted Successfull");
        return "redirect:/";
    }
    @PostMapping("/save")
    public String savePost(@Valid Categoria cat, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "add";
        }
        catService.create(cat);
        return "redirect:/";
    }
    @PostMapping("update/{id}")
    public String updatePost(@PathVariable("id") int id, @Valid Categoria cat, BindingResult result,
        Model model) {
        if (result.hasErrors()) {            
            return "edit";
        }
        catService.update(cat);
        model.addAttribute("categorias", catService.readAll());
        return "index";
    }
}
