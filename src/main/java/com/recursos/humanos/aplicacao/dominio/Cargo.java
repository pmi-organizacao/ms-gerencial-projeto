package com.recursos.humanos.aplicacao.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.recursos.humanos.aplicacao.Enum.ESenioridade;
import com.recursos.humanos.aplicacao.dto.request.cargo.CargoRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_CARGO")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nomeCargo;

    private String descCargo;
    @Enumerated(EnumType.STRING)
    private ESenioridade senioridade;

    private Boolean status;

    public static Cargo construirCargoAtravesDoCargoRequest(CargoRequest cargoRequest) {
        return Cargo.builder()
                .nomeCargo(cargoRequest.getNomeCargo())
                .descCargo(cargoRequest.getDescCargo())
                .senioridade(cargoRequest.getSenioridade())
                .status(true)
                .build();
    }
}
