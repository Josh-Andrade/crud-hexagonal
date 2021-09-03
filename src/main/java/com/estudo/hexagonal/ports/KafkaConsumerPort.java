package com.estudo.hexagonal.ports;

import com.estudo.hexagonal.domain.Usuario;

public interface KafkaConsumerPort {

    void consumirTopico(Usuario usuario);
}
