package com.movieTicket.MovieTicketApplication.Dtos.RequestDto;

import lombok.Data;

@Data
public class UserRequestDto {
    private String name;

    private int age;

    private String email;

    private int phoneNumber;
}
