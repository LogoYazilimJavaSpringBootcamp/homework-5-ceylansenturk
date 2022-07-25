package com.java.moviereviewsite.repositories;

import com.java.moviereviewsite.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByTitle(String title);
}
