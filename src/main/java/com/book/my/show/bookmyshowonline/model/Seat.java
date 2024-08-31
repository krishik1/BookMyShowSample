package com.book.my.show.bookmyshowonline.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="seats")
public class Seat extends  BaseModel{
    @Column(name="seat_row_number")
    private int rowNumber;
    @Column(name="seat_col_number")
    private int colNumber;
    private String seatNumber;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    @Enumerated(EnumType.STRING)
    private SeatStatus status;
}
