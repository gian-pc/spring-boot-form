package com.gianpc.app.editors;

import com.gianpc.app.services.IPais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class PaisEditor extends PropertyEditorSupport {
    @Autowired
    private IPais iPais;

    @Override
    public void setAsText(String codigo) throws IllegalArgumentException { // Estamos convirtiendo de un String codigo a un Pais
        this.setValue(iPais.obtenerPais(codigo));
    }
}
