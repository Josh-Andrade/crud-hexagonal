package com.estudo.hexagonal.ports;

import com.estudo.hexagonal.adapters.outbound.persistence.entities.UsuarioEntity;
import com.estudo.hexagonal.domain.Usuario;

import java.util.List;

public interface UsuarioRepositoryPort {

    Usuario save(UsuarioEntity usuario);

    List<Usuario> findAll();

    UsuarioEntity findByNome(String nome) throws Throwable;

    void delete(UsuarioEntity entity);

    UsuarioEntity findById(String id) throws Throwable;

}
