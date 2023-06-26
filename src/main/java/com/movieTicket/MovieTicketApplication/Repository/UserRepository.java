package com.movieTicket.MovieTicketApplication.Repository;

import com.movieTicket.MovieTicketApplication.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
