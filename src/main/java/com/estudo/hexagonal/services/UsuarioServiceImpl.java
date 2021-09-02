package com.estudo.hexagonal.application.services;

import com.estudo.hexagonal.adapters.dto.UsuarioRequest;
import com.estudo.hexagonal.adapters.dto.UsuarioResponse;
import com.estudo.hexagonal.adapters.outbound.persistence.entities.UsuarioEntity;
import com.estudo.hexagonal.application.domain.Usuario;
import com.estudo.hexagonal.application.ports.UsuarioRepositoryPort;
import com.estudo.hexagonal.application.ports.UsuarioServicePort;
import org.modelmapper.ModelMapper;

import javax.transaction.Transactional;
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
    public List<UsuarioResponse> listarUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponse buscarUsuario(String nome) throws Throwable {
        UsuarioEntity entity = usuarioRepository.findByNome(nome);
        return modelMapper.map(entity, UsuarioResponse.class);
    }

    @Override
    public void deletarUsuario(String id) throws Throwable {
        usuarioRepository.delete(usuarioRepository.findById(id));
    }

    @Override
    @Transactional
    public UsuarioResponse atualizarUsuario(UsuarioRequest request, String id) throws Throwable {
        UsuarioEntity entity = usuarioRepository.findById(id);
        entity.setNome(request.getNome());
        entity.setIdade(request.getIdade());
        return modelMapper.map(entity, UsuarioResponse.class);
    }


}
