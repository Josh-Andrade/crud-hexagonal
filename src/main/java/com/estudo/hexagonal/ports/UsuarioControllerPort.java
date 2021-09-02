package com.estudo.hexagonal.application.ports;

import com.estudo.hexagonal.adapters.dto.UsuarioRequest;
import com.estudo.hexagonal.adapters.dto.UsuarioResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioControllerPort {

    ResponseEntity<UsuarioResponse> salvar(UsuarioRequest usuario);

    ResponseEntity<List<UsuarioResponse>> listar();

    ResponseEntity<?> deletar(String id) throws Throwable;

    ResponseEntity<UsuarioResponse> buscarUsuario(String nome) throws Throwable;

    ResponseEntity<UsuarioResponse> atualizarUsuario(UsuarioRequest usuario, String id) throws Throwable;
}
