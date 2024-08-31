package com.book.my.show.bookmyshowonline.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel{
    private String audiToriumName;
    private int capacity;
    @OneToMany
    private List<Show> shows;
    @OneToMany
    private List<Seat> seats;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private  List<AuditoriumFeature> auditoriumFeatures;
}
