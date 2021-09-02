package com.estudo.hexagonal.application.ports;

import com.estudo.hexagonal.adapters.outbound.persistence.entities.UsuarioEntity;
import com.estudo.hexagonal.application.domain.Usuario;

import java.util.List;

public interface UsuarioRepositoryPort {

    Usuario save(UsuarioEntity usuario);

    List<Usuario> findAll();

    UsuarioEntity findByNome(String nome) throws Throwable;

    void delete(UsuarioEntity entity);

    UsuarioEntity findById(String id) throws Throwable;

}
