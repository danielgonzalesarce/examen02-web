package com.tecsup.hospital_gestion.controller;

import com.tecsup.hospital_gestion.model.entities.AntecedenteMedico;
import com.tecsup.hospital_gestion.model.entities.HistoriaClinica;
import com.tecsup.hospital_gestion.model.services.AntecedenteMedicoService;
import com.tecsup.hospital_gestion.model.services.HistoriaClinicaService;
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
}
