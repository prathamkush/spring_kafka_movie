package com.kafka.movie.consumer.KafkaMovieConsumer.Listener;

import com.kafka.movie.consumer.KafkaMovieConsumer.constants.KafkaConstants;
import com.kafka.movie.consumer.KafkaMovieConsumer.model.Movie;
import com.kafka.movie.consumer.KafkaMovieConsumer.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Consumer {

    @Autowired
    private MovieRepository movieRepository;

    @KafkaListener(topics = KafkaConstants.TOPIC, groupId = KafkaConstants.GROUP_ID)
    public void consume(Movie movie){
        System.out.println(movie);
        movieRepository.save(movie);
    }

}
