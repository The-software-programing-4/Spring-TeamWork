package com.example.bookandmovie.Service;

import com.example.bookandmovie.Entity.Movie;

public interface MovieService {
    public void addMovie(Movie movie);
    public Movie findMovie(String name);
}
