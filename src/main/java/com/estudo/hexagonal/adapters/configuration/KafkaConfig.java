package com.estudo.hexagonal.adapters.configuration;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

import static org.apache.kafka.clients.consumer.ConsumerConfig.*;

@Configuration
public class KafkaConfig {

    private final String kafkaServer;
    private final String groupId;
    private final Integer sessionTimeout;
    private final Boolean autoCommit;

    public KafkaConfig(@Value("${config.kafka.bootstrap.server}")String kafkaServer,
                       @Value("${config.kafka.groupId}") String groupId,
                       @Value("${config.kafka.sessionTimeout}") Integer sessionTimeout,
                       @Value("${config.kafka.autoCommit}") Boolean autoCommit) {
        this.kafkaServer = kafkaServer;
        this.groupId = groupId;
        this.sessionTimeout = sessionTimeout;
        this.autoCommit = autoCommit;
    }

    @Bean
    public ConsumerFactory<String, Object> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(Map.of(
                KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class,
                BOOTSTRAP_SERVERS_CONFIG, kafkaServer,
                GROUP_ID_CONFIG, groupId,
                ENABLE_AUTO_COMMIT_CONFIG, autoCommit,
                SESSION_TIMEOUT_MS_CONFIG, sessionTimeout
        ));
    }

    @Bean
    JsonMessageConverter jsonMessageConverter () {
        return new JsonMessageConverter();
    }
}
