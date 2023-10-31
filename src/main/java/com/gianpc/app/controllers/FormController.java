package com.gianpc.app.controllers;

import com.gianpc.app.models.domain.Usuario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("titulo", "Formulario Usuario");
        model.addAttribute("usuario", usuario);
        return "form";
    }
    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model){
        if(result.hasErrors()) {
            Map<String, String> errores = new HashMap<>(); // Con Map almacenamos el tag y la descripción del error debido a que es bidimensional
            result.getFieldErrors().forEach(error -> {// recorremos una lista de errores
                errores.put(error.getField(), error.getDefaultMessage());
            });
            model.addAttribute("titulo", "Formulario Usuario");
            model.addAttribute("error", errores);
            return "form";
        }
        model.addAttribute("titulo", "Resultado");
        model.addAttribute("usuario", usuario);
        return "resultado";
    }
}
