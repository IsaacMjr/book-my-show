package com.movieTicket.MovieTicketApplication.Controllers;

import com.movieTicket.MovieTicketApplication.Dtos.RequestDto.ShowReqDto;
import com.movieTicket.MovieTicketApplication.Dtos.RequestDto.ShowSeatReqDto;
import com.movieTicket.MovieTicketApplication.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    ShowService showService;

    @PostMapping("/add")
    public String addShow(@RequestBody ShowReqDto showDto){
        try {
            String response =showService.addShow(showDto);
            return response;
        }catch (Exception e){
            System.out.println(e);
            return e.getMessage();
        }
    }
    @PostMapping("/associate-seats")
    public String assignSeats(@RequestBody ShowSeatReqDto seatReqDto){
        try{
            String res =showService.associateSeats(seatReqDto);
            return res;
        }catch(Exception e ){
            return e.getMessage();
        }
    }
}
