package com.recursos.humanos.aplicacao.service.implementacao;

import com.recursos.humanos.aplicacao.Enum.EStatusProjeto;
import com.recursos.humanos.aplicacao.dominio.Colaborador;
import com.recursos.humanos.aplicacao.dominio.DadosProjetos;
import com.recursos.humanos.aplicacao.repository.DadosDeProjetoRepository;
import com.recursos.humanos.aplicacao.service.interfaces.ColaboradorService;
import com.recursos.humanos.aplicacao.service.interfaces.DadosDeProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DadosDeProjetoImplementacao implements DadosDeProjetoService {


    @Autowired
    private DadosDeProjetoRepository dadosDeProjetoRepository;

    @Autowired
    private ColaboradorService ColaboradorService;

    @Override
    public DadosProjetos buscarInformacoesAtualDoSDadosDeProjeto(Long id) {
        Colaborador colaborador = ColaboradorService.buscarColaboradorPeloId(id);
        return colaborador.getDadosProjetos();
    }

    @Override
    public Colaborador atualizarInformacoesDoDadosDeProjeto(Long id, EStatusProjeto eStatusProjeto, String idDoProjeto) {
        try{
            System.out.println("Buscar o colaborador de id: " + id);

            Colaborador colaborador = ColaboradorService.buscarColaboradorPeloId(id);
            System.out.println("Colaborador encontrado " + colaborador);
            colaborador.getDadosProjetos().setStatus(eStatusProjeto);
            colaborador.getDadosProjetos().setIdProjeto(idDoProjeto);
            System.out.println("Colaborador alterado" + colaborador);
            return ColaboradorService.alterarColaborador(id, colaborador.getColaboradorRequest());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
