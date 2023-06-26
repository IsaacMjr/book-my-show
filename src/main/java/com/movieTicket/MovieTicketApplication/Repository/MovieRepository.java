package com.movieTicket.MovieTicketApplication.Repository;

import com.movieTicket.MovieTicketApplication.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
