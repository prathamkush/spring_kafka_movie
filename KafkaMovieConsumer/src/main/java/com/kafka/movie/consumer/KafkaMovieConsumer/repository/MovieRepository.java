package com.kafka.movie.consumer.KafkaMovieConsumer.repository;

import com.kafka.movie.consumer.KafkaMovieConsumer.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

}
