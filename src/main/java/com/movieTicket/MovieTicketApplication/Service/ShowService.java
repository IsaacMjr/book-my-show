package com.movieTicket.MovieTicketApplication.Service;

import com.movieTicket.MovieTicketApplication.Dtos.RequestDto.ShowReqDto;
import com.movieTicket.MovieTicketApplication.Dtos.RequestDto.ShowSeatReqDto;
import com.movieTicket.MovieTicketApplication.Enums.SeatType;
import com.movieTicket.MovieTicketApplication.Exceptions.MovieException;
import com.movieTicket.MovieTicketApplication.Exceptions.ShowException;
import com.movieTicket.MovieTicketApplication.Exceptions.TheaterException;
import com.movieTicket.MovieTicketApplication.Models.*;
import com.movieTicket.MovieTicketApplication.Repository.MovieRepository;
import com.movieTicket.MovieTicketApplication.Repository.ShowRepository;
import com.movieTicket.MovieTicketApplication.Repository.TheaterRepository;
import com.movieTicket.MovieTicketApplication.Transformers.ShowTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private MovieRepository movieRepository;
    public String addShow(ShowReqDto showDto) throws MovieException, TheaterException {
        Show show = ShowTransformer.showDtoToEntity(showDto);

        Optional<Theater>optionalTheater = theaterRepository.findById(showDto.getTheaterId());
        if(optionalTheater.isEmpty()){
            throw new TheaterException("theater not found");
        }
        Optional<Movie>optionalMovie = movieRepository.findById(showDto.getMovieId());
        if(optionalMovie.isEmpty()){
            throw new MovieException("Movie not found");
        }
        Theater theater = optionalTheater.get();
        Movie movie = optionalMovie.get();
        //adding the foreign keys
        show.setTheater(theater);
        show.setMovie(movie);
        show = showRepository.save(show);

        //saving to the parent entity
        theater.getShows().add(show);
        theaterRepository.save(theater);

        movie.getShows().add(show);
        movieRepository.save(movie);




        return "show has been added to the database";
    }

    public String associateSeats(ShowSeatReqDto seatReqDto) throws ShowException {
        Optional<Show>showOptional = showRepository.findById(seatReqDto.getShowId());
        if(showOptional.isEmpty()){
            throw new ShowException("show does not exist");
        }
        //valid show
        Show show = showOptional.get();

        //getting the theater from the show
        Theater theater = show.getTheater();

        //getting the list of theater seats and x-tics to pass to show seat
        List<TheaterSeat>theaterSeatsList = theater.getSeatList();

//        List<ShowSeat>showSeatList = show.getShowSeats();

        for(TheaterSeat theaterSeat : theaterSeatsList){
            //create an object to save the info from theaterseat
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeatId(theaterSeat.getSeatNumber());
            showSeat.setSeatType(theaterSeat.getSeatType());

            if(showSeat.getSeatType().equals(SeatType.CLASSIC)){
                showSeat.setPrice(seatReqDto.getClassicSeatPrice());
            }else {
                showSeat.setPrice(seatReqDto.getPremiumSeatPrice());
            }
            showSeat.setFood(false);
            showSeat.setAvailable(true);

            //foreign key attribute
            showSeat.setShow(show);

            show.getShowSeats().add(showSeat);
        }

        showRepository.save(show);
        return "show seats have been added ";

    }
}
