package com.recursos.humanos.aplicacao.service.implementacao;

import com.recursos.humanos.aplicacao.Enum.EStatusProjeto;
import com.recursos.humanos.aplicacao.dominio.Colaborador;
import com.recursos.humanos.aplicacao.dto.request.cargo.ColaboradorRequest;
import com.recursos.humanos.aplicacao.dto.request.colaborador.ColaboradorReuqestDadosProjetoRequest;
import com.recursos.humanos.aplicacao.dto.response.AlterarStatusResponse;
import com.recursos.humanos.aplicacao.exceptions.excessoesTratadas.ColaboradorJaEstaRegistradoException;
import com.recursos.humanos.aplicacao.exceptions.excessoesTratadas.ColaboradorNaoEncontradoException;
import com.recursos.humanos.aplicacao.menssageria.AdicionarColaboradorQueue;
import com.recursos.humanos.aplicacao.repository.ColaboradorRepository;
import com.recursos.humanos.aplicacao.service.interfaces.CargoService;
import com.recursos.humanos.aplicacao.service.interfaces.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorImplementacao implements ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private CargoService cargoService;

    @Autowired
    private AdicionarColaboradorQueue queue;


    @Override
    public Colaborador registrarNovoColaborador(ColaboradorRequest colaboradorRequest) {
        System.out.println(colaboradorRequest.toString());
        if (colaboradorRepository.existsByDadosPessoaisNomeCompleto(colaboradorRequest.getDadosPessoais().getNomeCompleto()))
            throw new ColaboradorJaEstaRegistradoException("Colaborador de nome " + colaboradorRequest.getDadosPessoais().getNomeCompleto() + " já está cadastrado.");
        System.out.println("primeira validacao");
        if (colaboradorRepository.existsByDadosPessoaisCpf(colaboradorRequest.getDadosPessoais().getCpf()))
            throw new ColaboradorNaoEncontradoException("Colaborador de cpf " + colaboradorRequest.getDadosPessoais().getCpf() + " já está cadastrado.");
        System.out.println("segunda validacao");
        Colaborador colaborador = Colaborador.construirColaboradorPeloSeuRquest(colaboradorRequest, cargoService);
        System.out.println(colaborador.toString());
        var colaboradorSalvo = colaboradorRepository.save(colaborador);
        System.out.println("colaborador salvo " + colaboradorSalvo);
        queue.novoColaboradorAdicionado(Colaborador.construirDadoDeTransferencia(colaboradorSalvo));
        return colaboradorSalvo;
    }

    @Override
    public Colaborador buscarColaboradorPeloIdEStatus(Long id, Boolean status) {

        return colaboradorRepository.findByIdAndAtivo(id, status)
                .orElseThrow(() -> new ColaboradorNaoEncontradoException("Colaborador ativo: "+status+" com id "+ id +" não foi encontrado."));
    }

    @Override
    public Colaborador buscarColaboradorPeloId(Long id) {
        return colaboradorRepository.findById(id)
                .orElseThrow(() -> new ColaboradorNaoEncontradoException("Colaborador com id "+ id +" não foi encontrado."));
    }

    @Override
    public List<Colaborador> buscarTodosOsColaboradoresPorStatus(Boolean status) {
        return colaboradorRepository.findAllByAtivo(status);
    }

    @Override
    public List<Colaborador> buscarTodosOsColaboradores() {
        return colaboradorRepository.findAll();
    }

    @Override
    public Colaborador alterarColaborador(Long id, ColaboradorRequest colaboradorRequest) {
        var colaboradorAtual = this.buscarColaboradorPeloId(id);
        var colaboradorAtualizado = Colaborador.construirColaboradorPeloSeuRquest(colaboradorRequest, cargoService);
        colaboradorAtualizado.setId(colaboradorAtual.getId());
        return colaboradorRepository.save(colaboradorAtualizado);
    }
    @Override
    public Colaborador alterarColaborador(Long id, ColaboradorReuqestDadosProjetoRequest colaboradorRequest) {
        System.out.println("Alterar colaborador inicio: "+ id +" "+colaboradorRequest);
        var colaboradorAtual = this.buscarColaboradorPeloId(id);
        System.out.println("colaborador atualizado medio: "+ id +" "+colaboradorRequest);
        var colaboradorAtualizado = Colaborador.construirColaboradorPeloSeuRquest(colaboradorRequest, cargoService);
        colaboradorAtualizado.setId(colaboradorAtual.getId());
        Colaborador colaboradorSalvo = colaboradorRepository.save(colaboradorAtualizado);
        System.out.println("Colaborador salvo: " + colaboradorSalvo);
        return colaboradorSalvo;
    }

    @Override
    public AlterarStatusResponse alterarStatusColaborador(Long id, Boolean status) {
        Colaborador colaborador = this.buscarColaboradorPeloId(id);

        if (colaborador.getAtivo().equals(status)) {
            return AlterarStatusResponse.statusNaoAtualizadoPorqueEIgualAoAnterior(status);
        }

        var statusAlteradoComSucesso = AlterarStatusResponse
                .alterarStatusDePara(colaborador.getAtivo(), status);
        colaborador.setAtivo(status);
        colaboradorRepository.save(colaborador);
        return statusAlteradoComSucesso;
    }

    @Override
    public Boolean removerColaboradorPorId(Long id) {
        colaboradorRepository.delete(buscarColaboradorPeloId(id));
        return null;
    }

    @Override
    public Boolean isColaboradorDisponivel(Long id, Boolean status) {
        Colaborador empty = colaboradorRepository.findByIdAndAtivoAndDadosProjetosStatus(id, status, EStatusProjeto.DISPONIVEL)
                .orElseThrow(() -> new ColaboradorNaoEncontradoException("Colaborador não encontrado dados projeto status"));
        System.out.println(empty);
        if (empty.getAtivo()){
           return true;
       };
        return false;
    }
}
