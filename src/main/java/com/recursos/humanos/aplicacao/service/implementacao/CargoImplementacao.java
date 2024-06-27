package com.recursos.humanos.aplicacao.service.implementacao;


import com.recursos.humanos.aplicacao.dominio.Cargo;
import com.recursos.humanos.aplicacao.dto.request.cargo.CargoRequest;
import com.recursos.humanos.aplicacao.dto.response.AlterarStatusResponse;
import com.recursos.humanos.aplicacao.exceptions.excessoesTratadas.CargoJaEstaRegistradoException;
import com.recursos.humanos.aplicacao.exceptions.excessoesTratadas.CargoNaoEncontradoExceptions;
import com.recursos.humanos.aplicacao.repository.CargoRepository;
import com.recursos.humanos.aplicacao.service.interfaces.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoImplementacao implements CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public Cargo registrarNovoCargo(CargoRequest cargoRequest) {
            if(cargoRepository.existsByNomeCargo(cargoRequest.getNomeCargo()))
                    throw new CargoJaEstaRegistradoException("Nome do cargo "+ cargoRequest.getNomeCargo() +" já está registrado");

        return cargoRepository.save(Cargo.construirCargoAtravesDoCargoRequest(cargoRequest));
    }

    @Override
    public Cargo buscarCargoPeloIDEStatus(Long id, Boolean status) {
        return cargoRepository.findByIdAndStatus(id, status)
                .orElseThrow(() -> new CargoNaoEncontradoExceptions("Cargo "+ id + " não foi encontrado como cargo ativo."));
    }

    @Override
    public Cargo buscarCargoPeloID(Long id) {
        return cargoRepository.findById(id)
                .orElseThrow(() -> new CargoNaoEncontradoExceptions("Cargo "+ id + " não foi encontrado."));
    }

    @Override
    public Cargo alterarCargoPorId(Long id, CargoRequest cargoRequest) {
        Cargo cargo = this.buscarCargoPeloID(id);
        Cargo cargoAtual = Cargo.construirCargoAtravesDoCargoRequest(cargoRequest);
        cargoAtual.setId(cargo.getId());
        return cargoRepository.save(cargoAtual);
    }

    @Override
    public AlterarStatusResponse alterarStatusDoCargoPorId(Long id, Boolean status) {
        Cargo cargo = this.buscarCargoPeloID(id);

        if (cargo.getStatus().equals(status)) {
            return AlterarStatusResponse.statusNaoAtualizadoPorqueEIgualAoAnterior(status);
        }

        var statusAlteradoComSucesso = AlterarStatusResponse
                .alterarStatusDePara(cargo.getStatus(), status);
        cargo.setStatus(status);
        cargoRepository.save(cargo);
        return statusAlteradoComSucesso;
    }

    @Override
    public Boolean removerCargoPeloId(Long id) {
        cargoRepository.delete(buscarCargoPeloID(id));
        return true;
    }
}
