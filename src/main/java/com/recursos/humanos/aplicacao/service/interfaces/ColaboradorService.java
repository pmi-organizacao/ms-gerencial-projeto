package com.recursos.humanos.aplicacao.service.interfaces;

import com.recursos.humanos.aplicacao.dominio.Colaborador;
import com.recursos.humanos.aplicacao.dto.request.cargo.ColaboradorRequest;
import com.recursos.humanos.aplicacao.dto.request.colaborador.ColaboradorReuqestDadosProjetoRequest;
import com.recursos.humanos.aplicacao.dto.response.AlterarStatusResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ColaboradorService {

    Colaborador registrarNovoColaborador(ColaboradorRequest colaboradorRequest);
    Colaborador buscarColaboradorPeloIdEStatus(Long id, Boolean status);
    Colaborador buscarColaboradorPeloId(Long id);
    List<Colaborador> buscarTodosOsColaboradoresPorStatus(Boolean status);
    List<Colaborador> buscarTodosOsColaboradores();
    Colaborador alterarColaborador(Long id, ColaboradorRequest colaboradorRequest);
    Colaborador alterarColaborador(Long id, ColaboradorReuqestDadosProjetoRequest colaboradorRequest);
    AlterarStatusResponse alterarStatusColaborador(Long id, Boolean status);
    Boolean removerColaboradorPorId(Long id);
    Boolean isColaboradorDisponivel(Long id, Boolean status);
}
