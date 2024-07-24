package com.recursos.humanos.aplicacao.dto.request.colaborador;

import com.recursos.humanos.aplicacao.dominio.Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DadosParaContatoRquest {

    private List<TelefoneRequest> numerosContato = new ArrayList<>();

}
