package com.java.moviereviewsite.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    //Movie title
    @Column(unique = true)
    private String title;

    //Movie rating
    private Double score;

    //Nickname or alias
    private String alias;

    //Release Date
    @Column(name = "release_date")
    private String releaseDate;

    //Length
    private Integer length;

    //Director
    private String director;

    //Screen Writer
    private String screenwriter;



    //Overview
    @Column(columnDefinition = "text")
    private String overview;



    //Type
    @ManyToMany
    @JoinTable(name = "movie_type",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id"))
    private Set<Type> type;


    public Movie(String title, Double score){
        this.title = title;
        this.score = score;

    }

    public Movie(String title, Double score, String alias, String releaseDate, Integer length, String director, String screenwriter, String overview, Set<Type> type) {
        this.title = title;
        this.score = score;
        this.alias = alias;
        this.releaseDate = releaseDate;
        this.length = length;
        this.director = director;
        this.screenwriter = screenwriter;
        this.overview = overview;
        this.type = type;
    }

    public Movie() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getScreenwriter() {
        return screenwriter;
    }

    public void setScreenwriter(String screenwriter) {
        this.screenwriter = screenwriter;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Set<Type> getType() {
        return type;
    }

    public void setType(Set<Type> type) {
        this.type = type;
    }


}
