package com.tecsup.hospital_gestion.model.daos;

import com.tecsup.hospital_gestion.model.entities.AntecedenteMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AntecedenteMedicoRepository extends JpaRepository<AntecedenteMedico, Long> {
    List<AntecedenteMedico> findByPacienteIdPaciente(Long idPaciente);
}

