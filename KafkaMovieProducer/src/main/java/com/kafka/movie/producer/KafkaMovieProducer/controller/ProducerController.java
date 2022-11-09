package com.kafka.movie.producer.KafkaMovieProducer.controller;


import com.kafka.movie.producer.KafkaMovieProducer.constants.KafkaConstants;
import com.kafka.movie.producer.KafkaMovieProducer.model.Movie;
import com.kafka.movie.producer.KafkaMovieProducer.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutionException;


@RequiredArgsConstructor
@RestController
@RequestMapping("producer")
public class ProducerController {

    @Autowired
    MovieService movieService;

    private final KafkaTemplate<String, Movie> kafkaTemplate;

    @PostMapping(value = "/add-movie", consumes = "application/json", produces = "application/json")
    public Movie send(@RequestBody Movie movie){

        movie.setCreationDate(LocalDateTime.now().toString());

        try{
            kafkaTemplate.send(KafkaConstants.TOPIC, movie);
            return movieService.addMovie(movie);
        }

        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


    @GetMapping("get-movies")
    public List<Movie> getMovies(){
        return movieService.getMovies();
    }



}
