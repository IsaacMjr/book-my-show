package com.movieTicket.MovieTicketApplication.Service;

import com.movieTicket.MovieTicketApplication.Dtos.RequestDto.MovieReqDto;
import com.movieTicket.MovieTicketApplication.Models.Movie;
import com.movieTicket.MovieTicketApplication.Repository.MovieRepository;
import com.movieTicket.MovieTicketApplication.Transformers.MovieTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository ;
    public String addMovie(MovieReqDto movieReqDto){
        Movie movie = MovieTransformers.convertDtoToEntity(movieReqDto);
        movieRepository.save(movie);
        return "movie added";
    }
}
