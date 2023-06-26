package com.movieTicket.MovieTicketApplication.Controllers;

import com.movieTicket.MovieTicketApplication.Dtos.RequestDto.MovieReqDto;
import com.movieTicket.MovieTicketApplication.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/add")
    public String addMovie(@RequestBody MovieReqDto movieReqDto){
        return movieService.addMovie(movieReqDto);
    }
}
