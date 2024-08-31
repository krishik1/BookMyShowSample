package com.book.my.show.bookmyshowonline.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="movie_show")
public class Show extends  BaseModel{
    private String name;
    private String startTime;
    private String endTime;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Auditorium auditorium;
    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeats;
}
