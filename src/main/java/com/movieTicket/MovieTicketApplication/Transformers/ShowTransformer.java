package com.movieTicket.MovieTicketApplication.Transformers;

import com.movieTicket.MovieTicketApplication.Dtos.RequestDto.ShowReqDto;
import com.movieTicket.MovieTicketApplication.Models.Show;

public class ShowTransformer {

    public static Show showDtoToEntity(ShowReqDto showDto){
        Show show = Show.builder().time(showDto.getShowTime()).date(showDto.getShowDate())
                .build();
        return show;
    }
}
