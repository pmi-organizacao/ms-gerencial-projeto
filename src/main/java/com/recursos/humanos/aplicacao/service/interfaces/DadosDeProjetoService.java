package com.recursos.humanos.aplicacao.service.interfaces;

import com.recursos.humanos.aplicacao.Enum.EStatusProjeto;
import com.recursos.humanos.aplicacao.dominio.Colaborador;
import com.recursos.humanos.aplicacao.dominio.DadosProjetos;
import org.springframework.stereotype.Service;

@Service
public interface DadosDeProjetoService {

    DadosProjetos buscarInformacoesAtualDoSDadosDeProjeto(Long id);
    Colaborador atualizarInformacoesDoDadosDeProjeto(Long id, EStatusProjeto eStatusProjeto, String idDoProjeto);

}
