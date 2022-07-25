package com.java.moviereviewsite.services;


import com.java.moviereviewsite.dto.EmailDto;
import com.java.moviereviewsite.model.Movie;
import com.java.moviereviewsite.model.Type;
import com.java.moviereviewsite.repositories.MovieRepository;
import com.java.moviereviewsite.repositories.TypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RabbitMQService rabbitMQService;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private TypeRepository typeRepository;


    public List<Movie> getMovieInfoList(@PathVariable("page") int page){
        Pageable pageable = PageRequest.of(page,12);
        Page<Movie> movies = movieRepository.findAll(pageable);
        return movies.getContent();
    }
    public Movie getMovieDetail(@PathVariable("title") String title){
        Movie movie = movieRepository.findByTitle(title);
        if(null == movie){
            log.info("Movie not found");
        }
        return movie;
    }
    public Movie addMovieInfo(@PathVariable("type") String type,
                               @RequestBody Movie movie){
        rabbitTemplate.convertAndSend("moviereviewsite.email", new EmailDto("user@gmail.com", "Movie",
                "Yeni film eklendi! Yorumları kaçırma."));
        Movie find = movieRepository.findByTitle(movie.getTitle());
        if(find != null){
            log.info("Movie duplicate");
        }
        Set<Type> movieType = new HashSet<>();
        for (String t:type.split("&")){
            movieType.add(typeRepository.findByName(t));
        }
        movie.setType(movieType);
        return movieRepository.save(movie);

    }


    public void deleteMovieInfo(@PathVariable("title") String title){
        Movie movie = movieRepository.findByTitle(title);
        if(movie == null){
            log.info("Movie not found");
        }
        movieRepository.delete(movie);

    }
}
