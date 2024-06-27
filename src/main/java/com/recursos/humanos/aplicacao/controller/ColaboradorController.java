package com.recursos.humanos.aplicacao.controller;

import com.recursos.humanos.aplicacao.dominio.Colaborador;
import com.recursos.humanos.aplicacao.dto.request.cargo.ColaboradorRequest;
import com.recursos.humanos.aplicacao.dto.response.AlterarStatusResponse;
import com.recursos.humanos.aplicacao.service.interfaces.CargoService;
import com.recursos.humanos.aplicacao.service.interfaces.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {
    @Autowired
    private ColaboradorService colaboradorService;

    @PostMapping("/adicionar-colaborador")
    public ResponseEntity<Colaborador> adicionarColaborador(@RequestBody ColaboradorRequest colaboradorRequest){
        System.out.println(colaboradorRequest.toString());
        return ResponseEntity.ok(colaboradorService.registrarNovoColaborador(colaboradorRequest));
    }

    @GetMapping("/buscar/por-id-status/{codigoColaborador}")
    public ResponseEntity<Colaborador> buscarColaboradorPorId(@PathVariable Long codigoColaborador, @RequestParam Boolean ativo) {
        return ResponseEntity.ok(colaboradorService.buscarColaboradorPeloIdEStatus(codigoColaborador, ativo));
    }
    @GetMapping("/buscar/por-status")
    public ResponseEntity<List<Colaborador>> buscarColaboradoresPorStatus(@RequestParam Boolean ativo) {
        return ResponseEntity.ok(colaboradorService.buscarTodosOsColaboradoresPorStatus(ativo));
    }
    @GetMapping("/buscar/todos")
    public ResponseEntity<List<Colaborador>> buscarTodosColaboradoresPorStatus() {
        return ResponseEntity.ok(colaboradorService.buscarTodosOsColaboradores());
    }
    @PutMapping("/alterar/por-id/{codigoColaborador}")
    public ResponseEntity<Colaborador> alterarColaboradorPorId(@PathVariable Long codigoColaborador, @RequestParam ColaboradorRequest colaboradorRequest) {
        return ResponseEntity.ok(colaboradorService.alterarColaborador(codigoColaborador, colaboradorRequest));
    }
    @PatchMapping("/alterar/status/por-id/{codigoColaborador}")
    public ResponseEntity<AlterarStatusResponse> alterarAtivoDoColaboradorPorId(@PathVariable Long codigoColaborador, @RequestParam Boolean ativo) {
        return ResponseEntity.ok(colaboradorService.alterarStatusColaborador(codigoColaborador, ativo));
    }
    @DeleteMapping("/deletar/por-id/{codigoColaborador}")
    public ResponseEntity<Boolean> deletarColaboradorPorId(@PathVariable Long codigoColaborador) {
        return ResponseEntity.ok(colaboradorService.removerColaboradorPorId(codigoColaborador));
    }

    @GetMapping("/buscar/verificar/disponivel/por-id/{codigoColaborador}")
    public ResponseEntity<Boolean> verificarSeEstarDisponivelColaboradorPorId(@PathVariable Long codigoColaborador, @RequestParam Boolean ativo) {
        System.out.println("passou aqui");
        return ResponseEntity.ok(colaboradorService.isColaboradorDisponivel(codigoColaborador, ativo));
    }



}
