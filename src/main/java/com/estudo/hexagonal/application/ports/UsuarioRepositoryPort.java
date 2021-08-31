package com.estudo.hexagonal.application.ports;

import com.estudo.hexagonal.adapters.outbound.persistence.entities.UsuarioEntity;
import com.estudo.hexagonal.application.domain.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepositoryPort {

    Usuario save(UsuarioEntity usuario);

    List<Usuario> findAll();

    Optional<UsuarioEntity> findByNome(String nome);

    void delete(UsuarioEntity entity);

    Optional<UsuarioEntity> findById(String id);

}
