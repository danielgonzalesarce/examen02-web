package com.tecsup.hospital_gestion.controller;

import com.tecsup.hospital_gestion.model.entities.HistoriaClinica;
import com.tecsup.hospital_gestion.model.entities.Paciente;
import com.tecsup.hospital_gestion.model.services.HistoriaClinicaService;
import com.tecsup.hospital_gestion.model.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/historias")
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    @Autowired
    private PacienteService pacienteService;

    // ========================
    // LISTAR HISTORIAS CLÍNICAS
    // ========================
    @GetMapping
    public String listarHistorias(Model model) {
        List<HistoriaClinica> historias = historiaClinicaService.listarTodos();
        model.addAttribute("historias", historias);
        return "historias/listarView"; // Esta es la vista que muestra la lista
    }

    // ========================
    // FORMULARIO NUEVO
    // ========================
    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("historia", new HistoriaClinica());
        model.addAttribute("pacientes", pacienteService.listarTodos());
        model.addAttribute("titulo", "Registrar Historia Clínica");
        return "historias/formView"; // Vista de formulario
    }

    // ========================
    // GUARDAR HISTORIA CLÍNICA
    // ========================
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("historia") HistoriaClinica historia,
                          @RequestParam("pacienteId") Long pacienteId,
                          RedirectAttributes redirectAttrs) {

        Paciente paciente = pacienteService.buscarPorId(pacienteId).orElse(null);

        if (paciente == null) {
            redirectAttrs.addFlashAttribute("msg", "El paciente no existe");
            return "redirect:/historias/form";
        }

        historia.setPaciente(paciente);
        historiaClinicaService.guardar(historia);
        redirectAttrs.addFlashAttribute("msg", "Historia clínica guardada correctamente ✅");
        return "redirect:/historias";
    }

    // ========================
    // EDITAR HISTORIA CLÍNICA
    // ========================
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttrs) {
        HistoriaClinica historia = historiaClinicaService.buscarPorId(id).orElse(null);
        if (historia == null) {
            redirectAttrs.addFlashAttribute("msg", "La historia no existe");
            return "redirect:/historias";
        }

        model.addAttribute("historia", historia);
        model.addAttribute("pacientes", pacienteService.listarTodos());
        model.addAttribute("titulo", "Editar Historia Clínica");
        return "historias/formView"; // Misma vista de formulario
    }

    // ========================
    // ELIMINAR HISTORIA CLÍNICA
    // ========================
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id, RedirectAttributes redirectAttrs) {
        HistoriaClinica historia = historiaClinicaService.buscarPorId(id).orElse(null);

        if (historia != null) {
            historiaClinicaService.eliminar(id);
            redirectAttrs.addFlashAttribute("msg", "Historia clínica eliminada correctamente 🗑️");
        } else {
            redirectAttrs.addFlashAttribute("msg", "Historia clínica no encontrada ❌");
        }

        return "redirect:/historias"; // Regresa a la lista
    }

    // ========================
    // LISTAR POR PACIENTE
    // ========================
    @GetMapping("/paciente/{idPaciente}")
    public String listarPorPaciente(@PathVariable("idPaciente") Long idPaciente, Model model) {
        Paciente paciente = pacienteService.buscarPorId(idPaciente).orElse(null);
        if (paciente == null) {
            return "redirect:/pacientes";
        }
        
        List<HistoriaClinica> historias = historiaClinicaService.listarPorPaciente(idPaciente);
        model.addAttribute("historias", historias);
        model.addAttribute("paciente", paciente);
        return "historias/listarView";
    }

    // ========================
    // FORMULARIO NUEVO POR PACIENTE
    // ========================
    @GetMapping("/form/paciente/{idPaciente}")
    public String formPorPaciente(@PathVariable("idPaciente") Long idPaciente, Model model) {
        Paciente paciente = pacienteService.buscarPorId(idPaciente).orElse(null);
        if (paciente == null) {
            return "redirect:/pacientes";
        }
        
        HistoriaClinica historia = new HistoriaClinica();
        historia.setPaciente(paciente);
        
        model.addAttribute("historia", historia);
        model.addAttribute("paciente", paciente);
        model.addAttribute("titulo", "Registrar Historia Clínica - " + paciente.getNombres() + " " + paciente.getApellidos());
        return "historias/formView";
    }
}
