package com.java.moviereviewsite.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id", insertable = true, updatable = false)
    private List<Movie> movieInfoList = new ArrayList<>(10);

    public User() {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Movie> getMovieInfoList() {
        return movieInfoList;
    }

    public void setMovieInfoList(List<Movie> movieInfoList) {
        this.movieInfoList = movieInfoList;
    }




}
