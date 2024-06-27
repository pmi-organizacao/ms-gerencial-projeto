package com.recursos.humanos.aplicacao.dominio;

import com.recursos.humanos.aplicacao.menssageria.DadosTransferenciaAddColaboradorQueue;
import com.recursos.humanos.aplicacao.dto.request.cargo.ColaboradorRequest;
import com.recursos.humanos.aplicacao.dto.request.colaborador.ColaboradorReuqestDadosProjetoRequest;
import com.recursos.humanos.aplicacao.service.interfaces.CargoService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_COLABORADOR")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private DadosPessoais dadosPessoais;
    @Embedded
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @Embedded
    private DadosFinanceiro dadosFinanceiro;

    @Embedded
    private DadosProjetos dadosProjetos;

    private Boolean ativo;


    public static Colaborador construirColaboradorPeloSeuRquest(ColaboradorRequest colaboradorRequest, CargoService cargoService) {
        System.out.println("construindo o colaborador");
        return Colaborador.builder()
                .dadosPessoais(colaboradorRequest.getDadosPessoais())
                .endereco(colaboradorRequest.getEndereco())
                .dadosFinanceiro(colaboradorRequest.getDadosFinanceiro())
                .cargo(cargoService.buscarCargoPeloIDEStatus(colaboradorRequest.getIdCargo(), true))
                .ativo(true)
                .dadosProjetos(DadosProjetos.construirDadosDeProjetoBasico())
                .build();
    }
    public static Colaborador construirColaboradorPeloSeuRquest(ColaboradorReuqestDadosProjetoRequest colaboradorRequest, CargoService cargoService) {
        System.out.println("construindo o colaborador");
        return Colaborador.builder()
                .dadosPessoais(colaboradorRequest.getDadosPessoais())
                .endereco(colaboradorRequest.getEndereco())
                .dadosFinanceiro(colaboradorRequest.getDadosFinanceiro())
                .cargo(cargoService.buscarCargoPeloIDEStatus(colaboradorRequest.getIdCargo(), true))
                .ativo(true)
                .dadosProjetos(colaboradorRequest.getDadosProjetos())
                .build();
    }


    public static DadosTransferenciaAddColaboradorQueue construirDadoDeTransferencia(Colaborador colaboradorSalvo) {
        return DadosTransferenciaAddColaboradorQueue.builder()
                .id(colaboradorSalvo.getId())
                .nomeCompleto(colaboradorSalvo.dadosPessoais.getNomeCompleto())
                .nomeCargo(colaboradorSalvo.cargo.getNomeCargo())
                .build();
    }

    public ColaboradorReuqestDadosProjetoRequest getColaboradorRequest() {
        return ColaboradorReuqestDadosProjetoRequest.builder()
                .dadosFinanceiro(this.dadosFinanceiro)
                .dadosPessoais(this.dadosPessoais)
                .dadosProjetos(this.dadosProjetos)
                .endereco(this.endereco)
                .idCargo(this.cargo.getId())
                .build();

    }
}
