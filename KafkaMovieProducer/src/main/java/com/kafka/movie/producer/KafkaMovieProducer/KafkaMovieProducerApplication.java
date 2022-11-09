package com.kafka.movie.producer.KafkaMovieProducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;


@EnableKafka
@SpringBootApplication
public class KafkaMovieProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaMovieProducerApplication.class, args);
	}

}
