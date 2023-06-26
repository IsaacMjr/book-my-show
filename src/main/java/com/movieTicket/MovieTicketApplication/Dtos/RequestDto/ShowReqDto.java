package com.movieTicket.MovieTicketApplication.Dtos.RequestDto;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class ShowReqDto {

    private Date showDate;

    private LocalTime showTime;

    private int movieId;

    private int theaterId;

}
