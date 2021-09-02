package com.estudo.hexagonal.application.ports;

import com.estudo.hexagonal.adapters.dto.UsuarioRequest;
import com.estudo.hexagonal.adapters.dto.UsuarioResponse;

import java.util.List;

public interface UsuarioServicePort {

    UsuarioResponse salvarUsuario(UsuarioRequest request);

    List<UsuarioResponse> listarUsuarios();

    UsuarioResponse buscarUsuario(String nome) throws Throwable;

    void deletarUsuario(String id) throws Throwable;

    UsuarioResponse atualizarUsuario(UsuarioRequest request, String id) throws Throwable;
}
