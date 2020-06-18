package com.cs544.group7.reservationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs544.group7.reservationService.domain.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
