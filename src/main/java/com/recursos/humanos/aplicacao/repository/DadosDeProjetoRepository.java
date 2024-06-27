package com.recursos.humanos.aplicacao.repository;

import com.recursos.humanos.aplicacao.dominio.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface DadosDeProjetoRepository extends JpaRepository<Colaborador, Long> {



}
