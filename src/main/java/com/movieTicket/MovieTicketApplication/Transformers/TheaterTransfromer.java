package com.movieTicket.MovieTicketApplication.Transformers;

import com.movieTicket.MovieTicketApplication.Dtos.RequestDto.TheaterEntryDto;
import com.movieTicket.MovieTicketApplication.Models.Theater;

public class TheaterTransfromer {

    public static Theater theaterDtoToEntity(TheaterEntryDto theaterEntryDto){
        Theater theater = Theater.builder().location(theaterEntryDto.getLocation()).name(theaterEntryDto.getName()).build();
        return theater;
    }
}
