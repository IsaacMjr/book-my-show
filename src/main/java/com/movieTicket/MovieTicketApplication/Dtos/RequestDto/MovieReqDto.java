package com.movieTicket.MovieTicketApplication.Dtos.RequestDto;

import com.movieTicket.MovieTicketApplication.Enums.Genre;
import com.movieTicket.MovieTicketApplication.Enums.Language;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;


import java.util.Date;


@Data
public class MovieReqDto {
    private String name;

    private double duration;

    private int rating;

    private Date releaseDate;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Enumerated(EnumType.STRING)
    private Language language;


}
