package com.estudo.hexagonal.application.ports;

import com.estudo.hexagonal.adapters.inbound.dto.UsuarioRequest;
import com.estudo.hexagonal.adapters.inbound.dto.UsuarioResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioControllerPort {

    ResponseEntity<UsuarioResponse> salvar(UsuarioRequest usuario);

    ResponseEntity<List<UsuarioResponse>> listar();
}
