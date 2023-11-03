package com.gianpc.app.services;

import com.gianpc.app.models.domain.Pais;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PaisService implements IPais{

    private List<Pais> paises;

    // Constructor
    public PaisService() {
        paises = Arrays.asList(
                new Pais("PE", "Perú"),
                new Pais("AR", "Argentina"),
                new Pais("BO", "Bolivia"),
                new Pais("BR", "Brasil"),
                new Pais("CL", "Chile"),
                new Pais("CO", "Colombia"),
                new Pais("EC", "Ecuador")
        );
    }

    @Override
    public List<Pais> listarPaises() {
        return paises;
    }

    @Override
    public Pais obtenerPais(String codigo) {
        Pais resultado = null;
        for (Pais pais : paises) {
            if(codigo.equals(pais.getCodigo())){
                resultado = pais;
                break;
            }
        }
        return resultado;
    }
}
