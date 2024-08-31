package com.book.my.show.bookmyshowonline.service;

import com.book.my.show.bookmyshowonline.model.Movie;
import com.book.my.show.bookmyshowonline.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }
    public Movie getMovie(String movieName){
        return movieRepository.findMovieByMovieName(movieName);
    }
}
