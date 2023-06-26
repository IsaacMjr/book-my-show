package com.movieTicket.MovieTicketApplication.Models;

import com.movieTicket.MovieTicketApplication.Enums.SeatType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "show_seats")
@Data
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatId;
    private int price;
    private SeatType seatType;
    private boolean isAvailable;
    private boolean isFood;

    @ManyToOne
    @JoinColumn
    private Show show;

}
