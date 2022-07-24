package com.java.moviereviewsite.repositories;

import com.java.moviereviewsite.model.Movie;
import com.java.moviereviewsite.model.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByName(String name);

    @Query(nativeQuery = true)
    List<Movie> findMovies(@Param("typeName") String type, Pageable pageable);
    long countByName(String name);
}
