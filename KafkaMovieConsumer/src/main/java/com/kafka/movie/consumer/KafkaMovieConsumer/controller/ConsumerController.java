package com.kafka.movie.consumer.KafkaMovieConsumer.controller;


import com.kafka.movie.consumer.KafkaMovieConsumer.Listener.Consumer;
import com.kafka.movie.consumer.KafkaMovieConsumer.model.Movie;
import com.kafka.movie.consumer.KafkaMovieConsumer.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    MovieService movieService;


    @GetMapping("/get-movies")
    public List<Movie> getMovies(){
        return movieService.getMovies();
    }

}
