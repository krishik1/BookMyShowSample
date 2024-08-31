package com.book.my.show.bookmyshowonline.model;
import java.util.*;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Movie extends  BaseModel {
    private String movieName;
    private String description;
    @ManyToMany
    private List<Actor> actors;
    @Enumerated(EnumType.STRING)
    private MovieGenre movieGenres;

}
