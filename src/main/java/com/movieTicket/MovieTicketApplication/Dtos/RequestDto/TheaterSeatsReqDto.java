package com.movieTicket.MovieTicketApplication.Dtos.RequestDto;

import lombok.Data;

@Data
public class TheaterSeatsReqDto {
    private int numbOfSeatsIn1Row;
    private int numbOfClassicSeats;
    private int numbOfPremiumSeats;
    private String location;
}
