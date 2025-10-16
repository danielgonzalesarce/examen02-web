package com.tecsup.hospital_gestion.model.services;

import com.tecsup.hospital_gestion.model.entities.Paciente;
import java.util.List;
import java.util.Optional;

public interface PacienteService {

    List<Paciente> listarTodos();

    Optional<Paciente> buscarPorId(Long id);

    Paciente guardar(Paciente paciente);

    void eliminar(Long id);
}
