package com.recursos.humanos.aplicacao.dto.request.colaborador;

import com.recursos.humanos.aplicacao.dominio.DadosPessoais;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorDtoRequest {

    private DadosPessoais dadosPessoais;

}
