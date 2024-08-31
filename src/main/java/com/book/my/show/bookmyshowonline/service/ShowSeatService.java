package com.book.my.show.bookmyshowonline.service;

import com.book.my.show.bookmyshowonline.model.*;
import com.book.my.show.bookmyshowonline.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowSeatService {
    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private SeatService seatService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private AuditoriumService auditoriumService;

    @Autowired
    private ShowService showService;

    public ShowSeat getShowSeat(int seatId){
        return showSeatRepository.findById(seatId).get();
    }

    public ShowSeat saveShowSeat(ShowSeat seat) {
        return showSeatRepository.save(seat);
    }

    public List<ShowSeat> insertShowSeats() {
        // Create the necessary entities only once and reuse them
        List<ShowSeat> showSeats = new ArrayList<>();

        // Create and save a new Auditorium
        Auditorium auditorium = new Auditorium();
        auditorium.setAudiToriumName("Screen1");
        auditorium.setCapacity(100);
        auditorium=auditoriumService.saveAuditorium(auditorium);


        if (auditorium.getId() == null) {
            throw new RuntimeException("Failed to save Auditorium. No ID generated.");
        }

        // Create and save a new Movie
        Movie movie = new Movie();
        movie.setMovieName("Saripodha Shanivaram");
        movie.setMovieGenres(MovieGenre.THRILLER);
        movie=movieService.saveMovie(movie);

        // Make sure the movie has been saved and has an ID
        if (movie.getId() == null) {
            throw new RuntimeException("Failed to save Movie. No ID generated.");
        }

        // Create and save a new Show
        Show show = new Show();
        show.setName("First Show");
        show.setAuditorium(auditorium);
        show.setMovie(movie);
        show.setStartTime("06:00 PM");
        show.setEndTime("09:00 PM");
        try{
            show = showService.saveShows(show);
        } catch(Exception e){
            e.printStackTrace();
        }



        if (show.getId() ==null) {
            throw new RuntimeException("Failed to save Show. No ID generated.");
        }


        for (int i = 0; i < 200; i++) {
            // Create a new Seat
            Seat s = new Seat();
            char row = (char) ('a'+(i/20));
            int col = i%20;
            String seatNumber = row + " " + col;
            s.setSeatNumber(seatNumber);
            s.setRowNumber(row);
            s.setColNumber(col);
            s = seatService.saveSeat(s);



            if (s.getId() == null) {
                throw new RuntimeException("Failed to save Seat. No ID generated for seat number: " + seatNumber);
            }

            // Create a new ShowSeat and set its properties
            ShowSeat seat = new ShowSeat();
            seat.setSeat(s);
            seat.setShow(show); // Set the previously created show
            seat.setPrice(175);
            seat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);


            // Add the ShowSeat to the list
            showSeats.add(seat);
            try{
                showSeatRepository.save(seat);
            } catch (Exception e) {
                 e.printStackTrace();
            }

        }

        return showSeats;
    }

//    public List<ShowSeat> viewSeats(String movieName,String auditoriumName){
//        ShowSeat showSeat = new ShowSeat();
//        Movie movie = movieService.getMovie(movieName);
//        Auditorium auditorium = auditoriumService.getAuditorium(auditoriumName);
//        Show show = showService.getShowsByName(movie,auditorium);
//
//        showSeat.setShow(show);
//        List<ShowSeat> showSeats = showSeatRepository.findShowSeatsByShow(show);
//        return showSeats;
//    }
public Page<ShowSeat> viewSeats(String movieName,String auditoriumName,int page,int size){
    ShowSeat showSeat = new ShowSeat();
    Movie movie = movieService.getMovie(movieName);
    Auditorium auditorium = auditoriumService.getAuditorium(auditoriumName);
    Show show = showService.getShowsByName(movie,auditorium);

    showSeat.setShow(show);
    Pageable pageable = PageRequest.of(page,size);
    Page<ShowSeat> showSeats = showSeatRepository.findShowSeatsByShow(show,pageable);
    return showSeats;
}

}
