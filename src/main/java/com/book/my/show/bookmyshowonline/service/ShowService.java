package com.book.my.show.bookmyshowonline.service;

import com.book.my.show.bookmyshowonline.model.Auditorium;
import com.book.my.show.bookmyshowonline.model.Movie;
import com.book.my.show.bookmyshowonline.model.Show;
import com.book.my.show.bookmyshowonline.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;

    public Show saveShows(Show show){
        return showRepository.save(show);
    }

    public Show getShows(Movie movie, Auditorium auditorium) {
        return showRepository.findShowByMovieAndAuditorium(movie,auditorium);
    }
    public Show getShowsByName(Movie movie, Auditorium auditorium) {
        return showRepository.findShowByMovie_MovieNameAndAndAuditorium_AudiToriumName(movie.getMovieName(),auditorium.getAudiToriumName());
    }

}
