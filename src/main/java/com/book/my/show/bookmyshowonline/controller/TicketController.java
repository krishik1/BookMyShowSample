package com.book.my.show.bookmyshowonline.controller;

import com.book.my.show.bookmyshowonline.dto.TicketRequestDTO;
import com.book.my.show.bookmyshowonline.model.User;
import com.book.my.show.bookmyshowonline.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/ticket")
    public ResponseEntity generateTickets(@RequestBody TicketRequestDTO ticketRequestDTO) throws Exception {
        List<Integer> showIds =ticketRequestDTO.getSeatIds();
        User user = ticketRequestDTO.getUser();
        return ResponseEntity.ok(ticketService.genearateTicket(showIds, user));
    }
}
