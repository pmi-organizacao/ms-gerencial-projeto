package com.recursos.humanos.aplicacao.exceptions.handler;

import com.recursos.humanos.aplicacao.Enum.eexceptions.EDescError;
import com.recursos.humanos.aplicacao.exceptions.dominio.cargo.DefaultErroCargo;
import com.recursos.humanos.aplicacao.exceptions.dominio.cargo.StandarErroCargo;
import com.recursos.humanos.aplicacao.exceptions.excessoesTratadas.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class RestTemplateHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultErroCargo> handlerExceptions () {
        return ResponseEntity.ok(new DefaultErroCargo(HttpStatus.BAD_REQUEST.value(), EDescError.MENSSAGEM_ERRO_PADRAO.getDescricao()));
    }

    @ExceptionHandler(CargoJaEstaRegistradoException.class)
    public ResponseEntity<StandarErroCargo> handlerCargoJaEstaRegistradoException (CargoJaEstaRegistradoException e, HttpServletRequest request) {
        StandarErroCargo erro = StandarErroCargo.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.CONFLICT.value())
                .error(EDescError.MENSSAGEM_DADO_JA_EXISTENTE.getDescricao())
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(CargoNaoEncontradoExceptions.class)
    public ResponseEntity<StandarErroCargo> handlerCargoNaoEncontradoException (CargoNaoEncontradoExceptions e, HttpServletRequest request) {
        StandarErroCargo erro = StandarErroCargo.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error(EDescError.MENSSAGEM_DADO_NAO_ENCONTRADO.getDescricao())
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
    @ExceptionHandler(ColaboradorJaEstaRegistradoException.class)
    public ResponseEntity<StandarErroCargo> handlerCargoColaboradorJaEstaRegistradoException (ColaboradorJaEstaRegistradoException e, HttpServletRequest request) {
        StandarErroCargo erro = StandarErroCargo.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.CONFLICT.value())
                .error(EDescError.MENSSAGEM_DADO_JA_EXISTENTE.getDescricao())
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(ColaboradorNaoEncontradoException.class)
    public ResponseEntity<StandarErroCargo> handlerColaboradorNaoEncontradoException (ColaboradorNaoEncontradoException e, HttpServletRequest request) {
        StandarErroCargo erro = StandarErroCargo.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error(EDescError.MENSSAGEM_DADO_NAO_ENCONTRADO.getDescricao())
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
    @ExceptionHandler(MensageriaNovoColaboradorException.class)
    public ResponseEntity<StandarErroCargo> handlerMensageriaNovoColaboradorException (MensageriaNovoColaboradorException e, HttpServletRequest request) {
        StandarErroCargo erro = StandarErroCargo.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error(EDescError.MENSSAGEM_DADO_NAO_ENCONTRADO.getDescricao())
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}
