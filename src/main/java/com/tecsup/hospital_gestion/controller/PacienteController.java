package com.tecsup.hospital_gestion.controller;

import com.tecsup.hospital_gestion.model.entities.Paciente;
import com.tecsup.hospital_gestion.model.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // ========================
    // LISTAR PACIENTES
    // ========================
    @GetMapping
    public String listarPacientes(Model model) {
        List<Paciente> pacientes = pacienteService.listarTodos();
        model.addAttribute("pacientes", pacientes);
        return "pacientes/listarView"; // ✅ Ruta correcta
    }

    // ========================
    // FORMULARIO NUEVO
    // ========================
    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("paciente", new Paciente());
        model.addAttribute("titulo", "Registrar Paciente");
        return "pacientes/formView"; // ✅ Ruta correcta
    }

    // ========================
    // GUARDAR PACIENTE
    // ========================
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("paciente") Paciente paciente,
                          RedirectAttributes redirectAttrs) {
        pacienteService.guardar(paciente);
        redirectAttrs.addFlashAttribute("msg", "Paciente guardado correctamente");
        return "redirect:/pacientes";
    }

    // ========================
    // EDITAR PACIENTE
    // ========================
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttrs) {
        Paciente paciente = pacienteService.buscarPorId(id).orElse(null);
        if (paciente == null) {
            redirectAttrs.addFlashAttribute("msg", "El paciente no existe");
            return "redirect:/pacientes";
        }

        model.addAttribute("paciente", paciente);
        model.addAttribute("titulo", "Editar Paciente");
        return "pacientes/formView"; // ✅ Ruta correcta
    }

    // ========================
    // ELIMINAR PACIENTE
    // ========================
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id, RedirectAttributes redirectAttrs) {
        Paciente paciente = pacienteService.buscarPorId(id).orElse(null);
        if (paciente != null) {
            pacienteService.eliminar(id);
            redirectAttrs.addFlashAttribute("msg", "Paciente eliminado correctamente");
        } else {
            redirectAttrs.addFlashAttribute("msg", "Paciente no encontrado");
        }
        return "redirect:/pacientes";
    }
}
