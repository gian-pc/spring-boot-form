package com.gianpc.app.services;

import com.gianpc.app.models.domain.Pais;

import java.util.List;

public interface IPais {
    public List<Pais> listarPaises();
    public Pais obtenerPais(String codigo);

}
