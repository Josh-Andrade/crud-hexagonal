package com.estudo.hexagonal.application.services;

import com.estudo.hexagonal.adapters.inbound.dto.UsuarioRequest;
import com.estudo.hexagonal.adapters.inbound.dto.UsuarioResponse;
import com.estudo.hexagonal.adapters.outbound.persistence.entities.UsuarioEntity;
import com.estudo.hexagonal.application.domain.Usuario;
import com.estudo.hexagonal.application.ports.UsuarioRepositoryPort;
import com.estudo.hexagonal.application.ports.UsuarioServicePort;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
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
    public UsuarioResponse buscarUsuario(String nome) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findByNome(nome);
        validarSeUsuarioEstaPresente(usuario);
        return modelMapper.map(usuario.get(), UsuarioResponse.class);
    }

    @Override
    public void deletarUsuario(String id) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
        validarSeUsuarioEstaPresente(usuario);
        usuarioRepository.delete(usuario.get());
    }

    @Override
    @Transactional
    public UsuarioResponse atualizarUsuario(UsuarioRequest request, String id) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
        validarSeUsuarioEstaPresente(usuario);
        UsuarioEntity entity = usuario.get();
        entity.setNome(request.getNome());
        entity.setIdade(request.getIdade());
        return modelMapper.map(entity, UsuarioResponse.class);
    }

    private void validarSeUsuarioEstaPresente(Optional<UsuarioEntity> usuario){
        if(usuario.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado");
        }
    }

}
