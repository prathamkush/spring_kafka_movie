package com.kafka.movie.consumer.KafkaMovieConsumer.configuration;


import com.kafka.movie.consumer.KafkaMovieConsumer.constants.KafkaConstants;
import com.kafka.movie.consumer.KafkaMovieConsumer.model.Movie;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class ConsumerConfiguration {
    @Bean
    public Map<String, Object> consumerConfig(){
        Map<String, Object> config = new HashMap<>();


        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.BROKER);

        // creating group for consumer (this group will be able to consume messages)
        config.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstants.GROUP_ID);

        // decoding data keys
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        // decoding data values
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        //  fetching latest from the queue
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");

        return config;
    }

    // config given to ConsumerFactory and alongside deserializing the strings and jsons
    @Bean
    public ConsumerFactory<String, Movie> consumerFactory(){
        JsonDeserializer<Movie> deserializer = new JsonDeserializer<>(Movie.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);
        return new DefaultKafkaConsumerFactory<>(
                consumerConfig(),// method for creating "Producer Instances" on Kafka Broker
                new StringDeserializer(),
                deserializer
        );
    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Movie> kafkaListenerContainerFactory(){
        // concurrent message grabbing to KafkaListenerFactory
        ConcurrentKafkaListenerContainerFactory<String, Movie> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}