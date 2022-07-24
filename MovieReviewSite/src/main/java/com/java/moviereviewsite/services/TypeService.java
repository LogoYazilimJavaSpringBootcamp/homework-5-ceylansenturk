package com.java.moviereviewsite.services;

import com.java.moviereviewsite.model.Movie;
import com.java.moviereviewsite.model.Type;
import com.java.moviereviewsite.repositories.TypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Slf4j
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private RabbitMQService rabbitMQService;

    @Autowired
    private AmqpTemplate rabbitTemplate;


    public List<Movie> getMovieListByType(@PathVariable("type") String type,
                                                  @PathVariable("page") int page){
        List<Movie> movies = typeRepository.findMovies(type, PageRequest.of(page,12));
        return movies;
    }

    public List<Type> getAllTypes(){
        return typeRepository.findAll();
    }

}
