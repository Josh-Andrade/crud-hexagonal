package com.estudo.hexagonal.adapters.outbound.persistence;

import com.estudo.hexagonal.adapters.outbound.persistence.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataH2UsuarioInterface extends JpaRepository<UsuarioEntity, String> {
}
