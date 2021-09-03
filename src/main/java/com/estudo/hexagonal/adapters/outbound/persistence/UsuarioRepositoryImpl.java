package com.estudo.hexagonal.adapters.outbound.persistence;

import com.estudo.hexagonal.adapters.outbound.persistence.entities.UsuarioEntity;
import com.estudo.hexagonal.domain.Usuario;
import com.estudo.hexagonal.ports.UsuarioRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Supplier;
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
    public UsuarioEntity findByNome(String nome) throws Throwable {
        return repository.findByNome(nome).orElseThrow((Supplier<Throwable>) () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));
    }

    @Override
    @Transactional
    public void delete(UsuarioEntity entity) {
        repository.delete(entity);
    }

    @Override
    public UsuarioEntity findById(String id) throws Throwable {
        return repository.findById(id).orElseThrow((Supplier<Throwable>) () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));
    }
}
