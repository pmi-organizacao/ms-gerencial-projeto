package com.recursos.humanos.aplicacao.dominio;

import com.recursos.humanos.aplicacao.dto.request.colaborador.TelefoneRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dd;
    private String numeroContato;
    private String descricaoNumero;
    private Long colaboradorId;

    public static Telefone construirTelefone(TelefoneRequest telefoneRequest, Long id) {
        return Telefone.builder()
                .dd(telefoneRequest.getDd())
                .numeroContato(telefoneRequest.getNumeroContato())
                .descricaoNumero(telefoneRequest.getDescricaoNumero())
                .colaboradorId(id)
                .build();
    }
}
