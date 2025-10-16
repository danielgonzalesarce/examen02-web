package com.tecsup.hospital_gestion.model.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tecsup.hospital_gestion.model.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
