package com.example.bookandmovie.Service;

import com.example.bookandmovie.Entity.Movie;

import java.util.List;

public interface MovieService {
    public void addMovie(Movie movie);
    public Movie findMovie(String name);
    public List<Movie> listMovie();
    public Movie findMovieById(int id);
}
