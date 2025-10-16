package com.tecsup.hospital_gestion.model.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "historia_clinica")
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistoria;

    @ManyToOne
    @JoinColumn(name = "idPaciente", nullable = false)
    private Paciente paciente;

    private LocalDate fechaApertura;
    private String observaciones;

    public HistoriaClinica() {}

    @OneToMany(mappedBy = "historiaClinica", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<AntecedenteMedico> antecedentes = new ArrayList<>();

    public Long getIdHistoria() { return idHistoria; }
    public void setIdHistoria(Long idHistoria) { this.idHistoria = idHistoria; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public LocalDate getFechaApertura() { return fechaApertura; }
    public void setFechaApertura(LocalDate fechaApertura) { this.fechaApertura = fechaApertura; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}
