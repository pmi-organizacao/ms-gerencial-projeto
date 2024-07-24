package com.recursos.humanos.aplicacao.repository;

import com.recursos.humanos.aplicacao.dominio.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosContatoRepository extends JpaRepository<Telefone, Long> {
}
