package com.tecsup.hospital_gestion.model.services;

import com.tecsup.hospital_gestion.model.entities.HistoriaClinica;
import java.util.List;
import java.util.Optional;

public interface HistoriaClinicaService {

    List<HistoriaClinica> listarTodos();

    Optional<HistoriaClinica> buscarPorId(Long id);

    HistoriaClinica guardar(HistoriaClinica historiaClinica);

    void eliminar(Long id);
}
