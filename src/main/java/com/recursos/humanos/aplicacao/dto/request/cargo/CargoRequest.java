package com.recursos.humanos.aplicacao.dto.request.cargo;

import com.recursos.humanos.aplicacao.Enum.ESenioridade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CargoRequest {

    private String nomeCargo;
    private String descCargo;
    @Enumerated(EnumType.STRING)
    private ESenioridade senioridade;

}
