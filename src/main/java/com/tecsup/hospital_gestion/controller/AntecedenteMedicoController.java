package com.tecsup.hospital_gestion.controller;

import com.tecsup.hospital_gestion.model.entities.AntecedenteMedico;
import com.tecsup.hospital_gestion.model.entities.HistoriaClinica;
import com.tecsup.hospital_gestion.model.entities.Paciente;
import com.tecsup.hospital_gestion.model.services.AntecedenteMedicoService;
import com.tecsup.hospital_gestion.model.services.HistoriaClinicaService;
import com.tecsup.hospital_gestion.model.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/antecedentes")
public class AntecedenteMedicoController {

    @Autowired
    private AntecedenteMedicoService antecedenteMedicoService;

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    @Autowired
    private PacienteService pacienteService;

    // ========================
    // LISTAR
    // ========================
    @GetMapping
    public String listar(Model model) {
        List<AntecedenteMedico> antecedentes = antecedenteMedicoService.listarTodos();
        model.addAttribute("antecedentes", antecedentes);
        return "antecedentes/listarView";
    }

    // ========================
    // FORMULARIO NUEVO
    // ========================
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("antecedente", new AntecedenteMedico());
        model.addAttribute("historias", historiaClinicaService.listarTodos());
        model.addAttribute("titulo", "Registrar Antecedente Médico");
        return "antecedentes/formView";
    }

    // ========================
    // GUARDAR
    // ========================
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("antecedente") AntecedenteMedico antecedente,
                          @RequestParam("historiaClinicaId") Long historiaClinicaId,
                          RedirectAttributes redirectAttrs) {

        HistoriaClinica historia = historiaClinicaService.buscarPorId(historiaClinicaId).orElse(null);

        if (historia == null) {
            redirectAttrs.addFlashAttribute("msg", "La historia clínica seleccionada no existe");
            return "redirect:/antecedentes/form";
        }

        antecedente.setHistoriaClinica(historia);
        antecedenteMedicoService.guardar(antecedente);
        redirectAttrs.addFlashAttribute("msg", "Antecedente registrado correctamente ✅");
        return "redirect:/antecedentes";
    }

    // ========================
    // ELIMINAR
    // ========================
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id, RedirectAttributes redirectAttrs) {
        antecedenteMedicoService.eliminar(id);
        redirectAttrs.addFlashAttribute("msg", "Antecedente eliminado correctamente 🗑️");
        return "redirect:/antecedentes";
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
        
        List<AntecedenteMedico> antecedentes = antecedenteMedicoService.listarPorPaciente(idPaciente);
        model.addAttribute("antecedentes", antecedentes);
        model.addAttribute("paciente", paciente);
        return "antecedentes/listarView";
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
        
        AntecedenteMedico antecedente = new AntecedenteMedico();
        antecedente.setPaciente(paciente);
        
        model.addAttribute("antecedente", antecedente);
        model.addAttribute("paciente", paciente);
        model.addAttribute("historias", historiaClinicaService.listarPorPaciente(idPaciente));
        model.addAttribute("titulo", "Registrar Antecedente Médico - " + paciente.getNombres() + " " + paciente.getApellidos());
        return "antecedentes/formView";
    }

    // ========================
    // GUARDAR CON PACIENTE
    // ========================
    @PostMapping("/guardar/paciente")
    public String guardarPorPaciente(@ModelAttribute("antecedente") AntecedenteMedico antecedente,
                                   @RequestParam("pacienteId") Long pacienteId,
                                   @RequestParam(value = "historiaClinicaId", required = false) Long historiaClinicaId,
                                   RedirectAttributes redirectAttrs) {

        Paciente paciente = pacienteService.buscarPorId(pacienteId).orElse(null);
        if (paciente == null) {
            redirectAttrs.addFlashAttribute("msg", "El paciente no existe");
            return "redirect:/pacientes";
        }

        antecedente.setPaciente(paciente);
        
        if (historiaClinicaId != null) {
            HistoriaClinica historia = historiaClinicaService.buscarPorId(historiaClinicaId).orElse(null);
            antecedente.setHistoriaClinica(historia);
        }

        antecedenteMedicoService.guardar(antecedente);
        redirectAttrs.addFlashAttribute("msg", "Antecedente registrado correctamente ✅");
        return "redirect:/antecedentes/paciente/" + pacienteId;
    }
}
