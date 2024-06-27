package com.recursos.humanos.aplicacao.repository;

import com.recursos.humanos.aplicacao.dominio.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

    Boolean existsByNomeCargo(String nomeCargo);

    Optional<Cargo> findByIdAndStatus(Long id, Boolean ativo);


}
