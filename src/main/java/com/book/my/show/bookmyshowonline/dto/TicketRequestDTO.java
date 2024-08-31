package com.book.my.show.bookmyshowonline.dto;

import com.book.my.show.bookmyshowonline.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TicketRequestDTO {
    private List<Integer> seatIds;
    private User user;
}
