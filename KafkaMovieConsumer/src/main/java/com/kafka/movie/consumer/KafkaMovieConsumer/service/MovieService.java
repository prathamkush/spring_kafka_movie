package com.kafka.movie.consumer.KafkaMovieConsumer.service;


import com.kafka.movie.consumer.KafkaMovieConsumer.Listener.Consumer;
import com.kafka.movie.consumer.KafkaMovieConsumer.model.Movie;
import com.kafka.movie.consumer.KafkaMovieConsumer.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;


    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }


}

