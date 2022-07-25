package com.java.moviereviewsite.controller;


import com.java.moviereviewsite.model.Movie;
import com.java.moviereviewsite.model.Type;
import com.java.moviereviewsite.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping(value= "/{page}")
    public List<Movie> getMovieListByType(@PathVariable("type") String type,
                                                  @PathVariable("page") int page){
        return typeService.getMovieListByType(type, page);
    }

    @GetMapping(value = "/types")
    public List<Type> getAllTypes(){
        return typeService.getAllTypes();
    }
}
