package com.movieTicket.MovieTicketApplication.Controllers;

import com.movieTicket.MovieTicketApplication.Dtos.RequestDto.TheaterEntryDto;
import com.movieTicket.MovieTicketApplication.Dtos.RequestDto.TheaterSeatsReqDto;
import com.movieTicket.MovieTicketApplication.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;
    @PostMapping("/add")
    public String addTheater(@RequestBody TheaterEntryDto theaterEntryDto){
        String response = theaterService.addTheater(theaterEntryDto);
        return response;
    }

    @PostMapping("/add-seats")
    public String addTheaterSeats(@RequestBody TheaterSeatsReqDto seatsReqDto){
        return theaterService.addSeats(seatsReqDto);
    }
}
