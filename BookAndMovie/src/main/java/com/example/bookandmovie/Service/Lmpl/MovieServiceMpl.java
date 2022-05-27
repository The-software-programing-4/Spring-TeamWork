package com.example.bookandmovie.Service.Lmpl;

import com.example.bookandmovie.Dao.MovieDao;
import com.example.bookandmovie.Entity.Movie;
import com.example.bookandmovie.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceMpl implements MovieService {
    @Autowired
    private MovieDao movieDao;
    @Override
    public void addMovie(Movie movie){movieDao.addMovie(movie);}
    @Override
    public Movie findMovie(String name){return movieDao.findMovie(name);}
    @Override
    public List<Movie> listMovie(){return movieDao.listMovie();}
}
