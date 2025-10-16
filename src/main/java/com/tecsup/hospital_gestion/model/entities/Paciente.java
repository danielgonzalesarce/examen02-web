package com.tecsup.hospital_gestion.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long idPaciente;

    @NotBlank(message = "El DNI es obligatorio")
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 caracteres")
    @Column(length = 8, nullable = false)
    private String dni;

    @NotBlank(message = "Los nombres son obligatorios")
    @Column(length = 100, nullable = false)
    private String nombres;

    @NotBlank(message = "Los apellidos son obligatorios")
    @Column(length = 100, nullable = false)
    private String apellidos;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @NotBlank(message = "Debe seleccionar el sexo")
    @Column(length = 1, nullable = false)
    private String sexo; // M o F

    @Column(length = 200)
    private String direccion;

    @Column(length = 15)
    private String telefono;

    @Email(message = "Debe ingresar un correo válido")
    @Column(length = 100)
    private String correo;

    @Column(length = 10, nullable = false)
    private String estado = "activo"; // activo o inactivo

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<HistoriaClinica> historiaClinicas =  new ArrayList<>();

    // Constructor vacío
    public Paciente() {}

    // Getters y Setters
    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
