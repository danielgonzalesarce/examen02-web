package com.tecsup.hospital_gestion.model.services;

import com.tecsup.hospital_gestion.model.daos.HistoriaClinicaRepository;
import com.tecsup.hospital_gestion.model.entities.HistoriaClinica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {

    @Autowired
    private HistoriaClinicaRepository historiaRepository;

    @Override
    public List<HistoriaClinica> listarTodos() {
        return historiaRepository.findAll();
    }

    @Override
    public List<HistoriaClinica> listarPorPaciente(Long idPaciente) {
        return historiaRepository.findByPacienteIdPaciente(idPaciente);
    }

    @Override
    public Optional<HistoriaClinica> buscarPorId(Long id) {
        return historiaRepository.findById(id);
    }

    @Override
    public HistoriaClinica guardar(HistoriaClinica historiaClinica) {
        return historiaRepository.save(historiaClinica);
    }

    @Override
    public void eliminar(Long id) {
        historiaRepository.deleteById(id);
    }
}
