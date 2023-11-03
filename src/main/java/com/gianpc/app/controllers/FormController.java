package com.gianpc.app.controllers;

import com.gianpc.app.editors.PaisEditor;
import com.gianpc.app.models.domain.Pais;
import com.gianpc.app.models.domain.Usuario;
import com.gianpc.app.services.IPais;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.*;

@Controller
@SessionAttributes("usuario")
public class FormController {

    @Autowired
    private IPais iPais;

    @Autowired
    private PaisEditor paisEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Pais.class, "pais", paisEditor);
    };

    @GetMapping("/form")
    public String form(Model model){
        Usuario usuario = new Usuario();
        usuario.setId(1);
        model.addAttribute("titulo", "Formulario Usuario");
        model.addAttribute("usuario", usuario);
        return "form";
    }
    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status){
        if(result.hasErrors()) {
            model.addAttribute("titulo", "Formulario Usuario");
            return "form";
        }
        model.addAttribute("titulo", "Resultado");
        model.addAttribute("usuario", usuario);
        status.setComplete(); // luego de enviar al resultado se vacía
        return "resultado";
    }

    @ModelAttribute("listPaises")
    public List<String> listPaises() {
        return Arrays.asList("Perú","Argentina","Bolivia","Brasil","Chile", "Colombia");
    }

    @ModelAttribute("mapPaises")
    public Map<String,String> mapPaises() {
        Map<String,String> paises = new HashMap<>();
        paises.put("PE", "Perú");
        paises.put("CL", "Chile");
        paises.put("CO", "Colombia");
        return paises;
    }
    @ModelAttribute("objectPaises")
    public List<Pais> objectPaises() {
        return Arrays.asList(
                new Pais("PE", "Perú"),
                new Pais("AR", "Argentina"),
                new Pais("BO", "Bolivia"),
                new Pais("BR", "Brasil"),
                new Pais("CL", "Chile"),
                new Pais("CO", "Colombia"),
                new Pais("EC", "Ecuador")
        );
    }
    @ModelAttribute("objectPaisesV2")
    public List<Pais> objectPaisesV2() {
        return iPais.listarPaises();
    }

    @ModelAttribute("listRoles")
    public List<String> listRoles() {
        return Arrays.asList("ROLE_ADMIN","ROLE_USER","ROLE_MODERATOR");
    }
}
