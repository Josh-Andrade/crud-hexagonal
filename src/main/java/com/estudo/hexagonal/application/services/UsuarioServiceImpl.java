package com.estudo.hexagonal.application.services;

import com.estudo.hexagonal.adapters.inbound.dto.UsuarioRequest;
import com.estudo.hexagonal.adapters.inbound.dto.UsuarioResponse;
import com.estudo.hexagonal.adapters.outbound.persistence.entities.UsuarioEntity;
import com.estudo.hexagonal.application.domain.Usuario;
import com.estudo.hexagonal.application.ports.UsuarioRepositoryPort;
import com.estudo.hexagonal.application.ports.UsuarioServicePort;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioServiceImpl implements UsuarioServicePort {

    private final UsuarioRepositoryPort usuarioRepository;

    private final ModelMapper modelMapper;

    public UsuarioServiceImpl(UsuarioRepositoryPort usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UsuarioResponse salvarUsuario(UsuarioRequest request) {
        Usuario domain = modelMapper.map(request, Usuario.class);
        domain.gerarId();
        Usuario response = usuarioRepository.save(modelMapper.map(domain, UsuarioEntity.class));
        return modelMapper.map(response, UsuarioResponse.class);
    }

    @Override
    public List<UsuarioResponse> buscarUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioResponse.class))
                .collect(Collectors.toList());
    }

}
