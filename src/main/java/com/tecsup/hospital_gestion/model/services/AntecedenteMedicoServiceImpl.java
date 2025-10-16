package com.tecsup.hospital_gestion.model.services;

import com.tecsup.hospital_gestion.model.daos.AntecedenteMedicoRepository;
import com.tecsup.hospital_gestion.model.entities.AntecedenteMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AntecedenteMedicoServiceImpl implements AntecedenteMedicoService {

    @Autowired
    private AntecedenteMedicoRepository antecedenteRepository;

    @Override
    public List<AntecedenteMedico> listarTodos() {
        return antecedenteRepository.findAll();
    }

    @Override
    public List<AntecedenteMedico> listarPorPaciente(Long idPaciente) {
        return antecedenteRepository.findByPacienteIdPaciente(idPaciente);
    }

    @Override
    public Optional<AntecedenteMedico> buscarPorId(Long id) {
        return antecedenteRepository.findById(id);
    }

    @Override
    public AntecedenteMedico guardar(AntecedenteMedico antecedenteMedico) {
        return antecedenteRepository.save(antecedenteMedico);
    }

    @Override
    public void eliminar(Long id) {
        antecedenteRepository.deleteById(id);
    }
}
