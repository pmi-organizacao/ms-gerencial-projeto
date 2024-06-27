package com.recursos.humanos.aplicacao.controller;

import com.recursos.humanos.aplicacao.dominio.Cargo;
import com.recursos.humanos.aplicacao.dto.request.cargo.CargoRequest;
import com.recursos.humanos.aplicacao.dto.response.AlterarStatusResponse;
import com.recursos.humanos.aplicacao.service.interfaces.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @PostMapping("/adicionar-cargo")
    public ResponseEntity<Cargo> registrarNovoCargo(@RequestBody CargoRequest cargoRequest){
            return ResponseEntity.ok(cargoService.registrarNovoCargo(cargoRequest));
    }
    @GetMapping("/buscar/por-id/{codigoCargo}")
    public ResponseEntity<Cargo> registrarNovoCargo(@PathVariable Long codigoCargo, @RequestParam Boolean status){
        return ResponseEntity.ok(cargoService.buscarCargoPeloIDEStatus(codigoCargo, status));
    }
    @PutMapping("/alterar/por-id/{codigoCargo}")
    public ResponseEntity<Cargo> alterarCargoPorid(@PathVariable Long codigoCargo, @RequestBody CargoRequest cargoRequest){
        return ResponseEntity.ok(cargoService.alterarCargoPorId(codigoCargo, cargoRequest));
    }
    @PatchMapping("/alterar/status/por-id/{codigoCargo}")
    public ResponseEntity<AlterarStatusResponse> alterarStatusDoCargoPorid(@PathVariable Long codigoCargo, @RequestParam Boolean status){
        return ResponseEntity.ok(cargoService.alterarStatusDoCargoPorId(codigoCargo, status));
    }
    @DeleteMapping("/deletar/por-id/{codigoCargo}")
    public ResponseEntity<Boolean> alterarCargoPorid(@PathVariable Long codigoCargo){
        return ResponseEntity.ok(cargoService.removerCargoPeloId(codigoCargo));
    }
}
