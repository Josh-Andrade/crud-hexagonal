package com.estudo.hexagonal.adapters.outbound.persistence;

import com.estudo.hexagonal.adapters.inbound.dto.UsuarioResponse;
import com.estudo.hexagonal.adapters.outbound.persistence.entities.UsuarioEntity;
import com.estudo.hexagonal.application.domain.Usuario;
import com.estudo.hexagonal.application.ports.UsuarioRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UsuarioRepositoryImpl implements UsuarioRepositoryPort {

    private final SpringDataH2UsuarioInterface repository;

    private final ModelMapper modelMapper;

    public UsuarioRepositoryImpl(SpringDataH2UsuarioInterface repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public Usuario save(UsuarioEntity usuario) {
        return modelMapper.map(repository.save(usuario), Usuario.class);
    }

    @Override
    public List<Usuario> findAll() {
        return repository.findAll().stream()
                .map(usuarioEntity -> modelMapper.map(usuarioEntity, Usuario.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UsuarioEntity> findByNome(String nome) {
        return repository.findByNome(nome);
    }

    @Override
    @Transactional
    public void delete(UsuarioEntity entity) {
        repository.delete(entity);
    }

    @Override
    public Optional<UsuarioEntity> findById(String id) {
        return repository.findById(id);
    }
}
