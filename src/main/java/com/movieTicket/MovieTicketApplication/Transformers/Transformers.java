package com.movieTicket.MovieTicketApplication.Transformers;

import com.movieTicket.MovieTicketApplication.Dtos.RequestDto.UserRequestDto;
import com.movieTicket.MovieTicketApplication.Models.User;

public class Transformers {
    public static User dtoToEntity(UserRequestDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAge(userDto.getAge());
        user.setPhoneNumber(userDto.getPhoneNumber());

        return user;
    }
}
