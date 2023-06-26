package com.movieTicket.MovieTicketApplication.Controllers;

import com.movieTicket.MovieTicketApplication.Dtos.RequestDto.UserRequestDto;
import com.movieTicket.MovieTicketApplication.Models.User;
import com.movieTicket.MovieTicketApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String>addUser(@RequestBody UserRequestDto userDto){
        try{
            String ans = userService.addUser(userDto);
            return new ResponseEntity<>(ans, HttpStatus.OK);
        }catch (Exception e){
            String ans ="ans";
            return new ResponseEntity<>(ans, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getUserBelowAge")
    public ResponseEntity<?>getUsersBelowAge(@RequestParam Integer minAge){
        try{
            List<User> res = userService.getUsersBelowAge(minAge);
            return new ResponseEntity<>(res,HttpStatus.OK);
        }catch (Exception e){
            String res = e.getMessage();
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
    }
}
