package com.movieTicket.MovieTicketApplication.Transformers;

import com.movieTicket.MovieTicketApplication.Dtos.RequestDto.MovieReqDto;
import com.movieTicket.MovieTicketApplication.Models.Movie;

public class MovieTransformers {
    public static Movie convertDtoToEntity(MovieReqDto movieReqDto){
        Movie movie = Movie.builder().name(movieReqDto.getName()).
                genre(movieReqDto.getGenre()).duration(movieReqDto.getDuration())
                .rating(movieReqDto.getRating())
                .language(movieReqDto.getLanguage())
                .releaseDate(movieReqDto.getReleaseDate()).build();
        return movie;
    }
}

