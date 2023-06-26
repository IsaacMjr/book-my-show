package com.movieTicket.MovieTicketApplication.Dtos.RequestDto;

import com.movieTicket.MovieTicketApplication.Enums.SeatType;

import lombok.Data;

@Data
public class ShowSeatReqDto {
    private int showId;
    private int premiumSeatPrice;
    private int classicSeatPrice;
}
