package com.tecsup.hospital_gestion.model.daos;

import com.tecsup.hospital_gestion.model.entities.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Long> {
    List<HistoriaClinica> findByPacienteIdPaciente(Long idPaciente);
}
