package com.tecsup.hospital_gestion.model.services;

import com.tecsup.hospital_gestion.model.entities.AntecedenteMedico;
import java.util.List;
import java.util.Optional;

public interface AntecedenteMedicoService {

    List<AntecedenteMedico> listarTodos();

    List<AntecedenteMedico> listarPorPaciente(Long idPaciente);

    Optional<AntecedenteMedico> buscarPorId(Long id);

    AntecedenteMedico guardar(AntecedenteMedico antecedenteMedico);

    void eliminar(Long id);
}
