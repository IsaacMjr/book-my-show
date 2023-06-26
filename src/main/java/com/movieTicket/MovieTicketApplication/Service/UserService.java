package com.movieTicket.MovieTicketApplication.Service;

import com.movieTicket.MovieTicketApplication.Dtos.RequestDto.UserRequestDto;
import com.movieTicket.MovieTicketApplication.Exceptions.UserException;
import com.movieTicket.MovieTicketApplication.Models.User;
import com.movieTicket.MovieTicketApplication.Repository.UserRepository;
import com.movieTicket.MovieTicketApplication.Transformers.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public String addUser(UserRequestDto userDto) throws UserException {
        User user = Transformers.dtoToEntity(userDto);
        if(user ==null){
            throw new UserException("user is null");
        }
        userRepository.save(user);
        return userDto.getName()+" has been saved";
    }

    public List<User> getUsersBelowAge(Integer minAge) {
        List<User>users = userRepository.findAll();
        List<User>ans = new ArrayList<>();
        int maxAge =0;
        for(User user : users){
            if(user.getAge()>maxAge){
                maxAge = user.getAge();
                ans.add(user);
            }
        }
        return ans;
    }
}
