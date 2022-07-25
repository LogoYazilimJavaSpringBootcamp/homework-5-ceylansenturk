package com.java.moviereviewsite.controller;

import com.java.moviereviewsite.model.Movie;
import com.java.moviereviewsite.repositories.TypeRepository;
import com.java.moviereviewsite.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private TypeRepository typeRepository;

    @GetMapping(value = "/movie-list/{page}")
    public List<Movie> getMovieInfoList(@PathVariable("page") int page){
        return movieService.getMovieInfoList(page) ;
    }

    @GetMapping(value = "/{title}")
    public Movie getMovieDetail(@PathVariable("title") String title){
        return movieService.getMovieDetail(title);
    }

    @PostMapping(value = "/add-movie/{type}")
    public Movie addMovieInfo(@PathVariable("type") String type,
                               @RequestBody Movie movie){
        return movieService.addMovieInfo(type, movie);
    }
    @PostMapping(value = "/delete/{title}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteMovieInfo(@PathVariable("title") String title){
        movieService.deleteMovieInfo(title);
    }


}
