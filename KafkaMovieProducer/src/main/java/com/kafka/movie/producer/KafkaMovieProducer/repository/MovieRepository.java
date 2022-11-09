package com.kafka.movie.producer.KafkaMovieProducer.repository;

import com.kafka.movie.producer.KafkaMovieProducer.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

}
