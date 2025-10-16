package com.tecsup.hospital_gestion.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "antecedente_medico")
public class AntecedenteMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAntecedente;

    @ManyToOne
    @JoinColumn(name = "idPaciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "idHistoria")
    private HistoriaClinica historiaClinica;

    private String tipo; // alergias, enfermedades previas, cirugías
    private String descripcion;

    public AntecedenteMedico() {}

    public Long getIdAntecedente() { return idAntecedente; }
    public void setIdAntecedente(Long idAntecedente) { this.idAntecedente = idAntecedente; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public HistoriaClinica getHistoriaClinica() { return historiaClinica; }
    public void setHistoriaClinica(HistoriaClinica historiaClinica) { this.historiaClinica = historiaClinica; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
