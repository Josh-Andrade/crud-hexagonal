package com.estudo.hexagonal.application.ports;

import com.estudo.hexagonal.adapters.inbound.dto.UsuarioRequest;
import com.estudo.hexagonal.adapters.inbound.dto.UsuarioResponse;

import java.util.List;

public interface UsuarioServicePort {

    UsuarioResponse salvarUsuario(UsuarioRequest request);

    List<UsuarioResponse> listarUsuarios();

    UsuarioResponse buscarUsuario(String nome);

    void deletarUsuario(String id);

    UsuarioResponse atualizarUsuario(UsuarioRequest request, String id);
}
