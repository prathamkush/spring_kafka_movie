package com.kafka.movie.producer.KafkaMovieProducer.configuration;

import com.kafka.movie.producer.KafkaMovieProducer.constants.KafkaConstants;
import com.kafka.movie.producer.KafkaMovieProducer.model.Movie;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class ProducerConfiguration {


    @Bean  // configuration for producer
    public Map<String, Object> producerConfig(){
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.BROKER); //kafka server URL
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        // json serializer becoz of producer input
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        System.out.println(config);
        return config;
    }

    // configuration passed to producer factory
    @Bean
    public ProducerFactory<String, Movie> producerFactory(){
        // Send this to kafkaTemplate with all the configuration related details
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String, Movie> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }

}
