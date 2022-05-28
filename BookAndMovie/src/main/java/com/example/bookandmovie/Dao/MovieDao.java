package com.example.bookandmovie.Dao;

import com.example.bookandmovie.Entity.Movie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MovieDao {
    public void addMovie(Movie movie);
    public Movie findMovie(String name);
    public Movie findMovieById(int id);
    public List<Movie> listMovie();

}
