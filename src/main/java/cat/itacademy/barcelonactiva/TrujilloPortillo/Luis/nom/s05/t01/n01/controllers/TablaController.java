package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.nom.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.nom.s05.t01.n01.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.nom.s05.t01.n01.model.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TablaController {
    private final SucursalService sucursalService;

    @Autowired
    public TablaController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<SucursalDto> sucursales = sucursalService.getAllSucursales();
        model.addAttribute("sucursales", sucursales);
        return "tabla";
    }
}

