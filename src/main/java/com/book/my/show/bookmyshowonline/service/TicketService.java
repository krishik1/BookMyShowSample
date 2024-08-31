package com.book.my.show.bookmyshowonline.service;

import com.book.my.show.bookmyshowonline.model.*;
import com.book.my.show.bookmyshowonline.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowSeatService showSeatService;
    @Autowired
    private UserService userService;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket genearateTicket(List<Integer> showSeatIds, User user) throws Exception {
        Ticket ticket = new Ticket();
        for(Integer showSeatId : showSeatIds){
            ShowSeat seat = showSeatService.getShowSeat(showSeatId);
            if(!seat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new Exception("Seat is Not Available Anymore.");
            }
        }

        for (Integer showSeatId : showSeatIds) {
            ShowSeat seat = showSeatService.getShowSeat(showSeatId);
            seat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatService.saveShowSeat(seat);
        }

        //payment
        if(startPayment()){
            ticket.setTicketStatus(TicketStatus.BOOKED);
            List<ShowSeat> showSeats = new ArrayList<>();
            int price =0;
            for (Integer showSeatId : showSeatIds) {
                ShowSeat seat = showSeatService.getShowSeat(showSeatId);
                seat.setShowSeatStatus(ShowSeatStatus.BOOKED);
                showSeatService.saveShowSeat(seat);
                showSeats.add(seat);
                price = seat.getPrice();
            }
            ticket.setShowSeats(showSeats);
            User currUser = userService.retirveUser(user);
            ticket.setUser(currUser);
            price *= showSeats.size();
            System.out.println("Total price Of Tickets is : "+price);
            ticket.setTotalAmount(price);
            ticketRepository.save(ticket);
        }
        return  ticket;
    }
    public boolean startPayment() {
        return true;
    }



}
