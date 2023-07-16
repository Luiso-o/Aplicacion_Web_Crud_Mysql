package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.nom.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.nom.s05.t01.n01.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.nom.s05.t01.n01.model.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {
    private final SucursalService sucursalService;

    @Autowired
    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping
    public ResponseEntity<List<SucursalDto>> getAllSucursales() {
        List<SucursalDto> sucursales = sucursalService.getAllSucursales();
        return ResponseEntity.ok(sucursales);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SucursalDto> getSucursalById(@PathVariable Integer id) {
        SucursalDto sucursal = sucursalService.getSucursalById(id);
        if (sucursal != null) {
            return ResponseEntity.ok(sucursal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> createSucursal(@RequestBody SucursalDto sucursalDto) {
        sucursalService.createSucursal(sucursalDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSucursal(@PathVariable Integer id, @RequestBody SucursalDto sucursalDto) {
        sucursalService.updateSucursal(id, sucursalDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSucursal(@PathVariable Integer id) {
        sucursalService.deleteSucursal(id);
        return ResponseEntity.ok().build();
    }
}