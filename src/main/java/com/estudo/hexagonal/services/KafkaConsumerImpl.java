package com.estudo.hexagonal.services;

import com.estudo.hexagonal.adapters.outbound.persistence.entities.UsuarioEntity;
import com.estudo.hexagonal.domain.Usuario;
import com.estudo.hexagonal.ports.KafkaConsumerPort;
import com.estudo.hexagonal.ports.UsuarioRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaConsumerImpl implements KafkaConsumerPort {

    private final UsuarioRepositoryPort usuarioRepository;

    private final ModelMapper modelMapper;

    public KafkaConsumerImpl(UsuarioRepositoryPort usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @KafkaListener(topics = "${config.kafka.nomeTopico}", groupId = "{config.kafka.groupId}")
    public void consumirTopico(Usuario usuario) {
        usuarioRepository.save(modelMapper.map(usuario, UsuarioEntity.class));
    }
}
