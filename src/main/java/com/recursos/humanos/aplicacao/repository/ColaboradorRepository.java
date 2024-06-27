package com.recursos.humanos.aplicacao.repository;

import com.recursos.humanos.aplicacao.Enum.EStatusProjeto;
import com.recursos.humanos.aplicacao.dominio.Cargo;
import com.recursos.humanos.aplicacao.dominio.Colaborador;
import com.recursos.humanos.aplicacao.dto.request.cargo.ColaboradorRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
    Boolean existsByDadosPessoaisNomeCompleto(String nomeCompleto);

    Boolean existsByDadosPessoaisCpf(String cpf);

    Optional<Colaborador> findByIdAndAtivo(Long id, Boolean ativo);
    Optional<Colaborador> findByIdAndAtivoAndDadosProjetosStatus(Long id, Boolean ativo, EStatusProjeto eStatusProjeto);

    List<Colaborador> findAllByAtivo(Boolean ativo);
}
