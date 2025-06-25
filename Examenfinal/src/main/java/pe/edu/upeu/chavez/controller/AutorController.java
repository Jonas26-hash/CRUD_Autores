package pe.edu.upeu.chavez.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.chavez.entity.Autor;
import pe.edu.upeu.chavez.repository.AutorRepository;

@Controller
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public String listarAutores(Model model) {
        model.addAttribute("autores", autorRepository.findAll());
        return "autores/index";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("autor", new Autor());
        return "autores/form";
    }

    @PostMapping("/guardar")
    public String guardarAutor(@ModelAttribute Autor autor) {
        autorRepository.save(autor);
        return "redirect:/autores";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Autor autor = autorRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ID de autor inválido:" + id));
        model.addAttribute("autor", autor);
        return "autores/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAutor(@PathVariable Long id) {
        autorRepository.deleteById(id);
        return "redirect:/autores";
    }
}