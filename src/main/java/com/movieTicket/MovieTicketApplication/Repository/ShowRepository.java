package com.movieTicket.MovieTicketApplication.Repository;

import com.movieTicket.MovieTicketApplication.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
}
