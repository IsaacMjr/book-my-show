package com.movieTicket.MovieTicketApplication.Service;

import com.movieTicket.MovieTicketApplication.Dtos.RequestDto.TheaterEntryDto;
import com.movieTicket.MovieTicketApplication.Dtos.RequestDto.TheaterSeatsReqDto;
import com.movieTicket.MovieTicketApplication.Enums.SeatType;
import com.movieTicket.MovieTicketApplication.Models.Theater;
import com.movieTicket.MovieTicketApplication.Models.TheaterSeat;
import com.movieTicket.MovieTicketApplication.Repository.TheaterRepository;
import com.movieTicket.MovieTicketApplication.Transformers.TheaterTransfromer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class TheaterService {
    @Autowired
    TheaterRepository theaterRepository;
    public String addTheater(TheaterEntryDto theaterEntryDto){
        Theater theater = TheaterTransfromer.theaterDtoToEntity(theaterEntryDto);
        theaterRepository.save(theater);
        return "theater added successfully";
    }

    public String addSeats(TheaterSeatsReqDto seatsReqDto) {
        int classicNumber = seatsReqDto.getNumbOfClassicSeats();
        int premiumNumber = seatsReqDto.getNumbOfPremiumSeats();
        int columnNumber = seatsReqDto.getNumbOfSeatsIn1Row();

        Theater theater = theaterRepository.findByLocation(seatsReqDto.getLocation());

        List<TheaterSeat>seatList = theater.getSeatList();

        int counter =1;
        char ch ='A';

        //we are going to store the seats and seat number in the database
        for(int count=1; count<=classicNumber; count++){
            String seatNo = counter+"";
            seatNo+=ch;
            ch++;

            if((ch-'A'+1)==columnNumber){
                ch ='A';
                counter++;
            }

            TheaterSeat theaterSeat = new TheaterSeat();
            theaterSeat.setTheater(theater);
            theaterSeat.setSeatNumber(seatNo);
            theaterSeat.setSeatType(SeatType.CLASSIC);


            //saving the child in the parent
            seatList.add(theaterSeat);

        }

        for(int count =1; count<=premiumNumber; count++){
            String seatNo = counter+"";
            seatNo+=ch;
            ch++;

            if((ch-'A'+1)==columnNumber){
                ch ='A';
                counter++;
            }
            TheaterSeat theaterSeat = new TheaterSeat();
            theaterSeat.setTheater(theater);
            theaterSeat.setSeatType(SeatType.PREMIUM);
            theaterSeat.setSeatNumber(seatNo);

            seatList.add(theaterSeat);
        }
        theaterRepository.save(theater);

        return "number of seats added";
    }
}
