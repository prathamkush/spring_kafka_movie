package com.kafka.movie.consumer.KafkaMovieConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class KafkaMovieConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaMovieConsumerApplication.class, args);
	}

}
