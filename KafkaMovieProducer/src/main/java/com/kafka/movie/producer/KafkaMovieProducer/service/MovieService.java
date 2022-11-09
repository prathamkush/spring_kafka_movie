package com.kafka.movie.producer.KafkaMovieProducer.service;


import com.kafka.movie.producer.KafkaMovieProducer.model.Movie;
import com.kafka.movie.producer.KafkaMovieProducer.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

}

