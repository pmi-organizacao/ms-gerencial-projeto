package com.recursos.humanos.aplicacao.service.interfaces;

import com.recursos.humanos.aplicacao.dominio.Cargo;
import com.recursos.humanos.aplicacao.dto.request.cargo.CargoRequest;
import com.recursos.humanos.aplicacao.dto.response.AlterarStatusResponse;
import org.springframework.stereotype.Service;

@Service
public interface CargoService {

    Cargo registrarNovoCargo(CargoRequest cargoRequest);
    Cargo buscarCargoPeloIDEStatus(Long id, Boolean status);
    Cargo buscarCargoPeloID(Long id);
    Cargo alterarCargoPorId(Long id, CargoRequest cargoRequest);

    AlterarStatusResponse alterarStatusDoCargoPorId(Long id, Boolean status);
    Boolean removerCargoPeloId(Long id);

}
