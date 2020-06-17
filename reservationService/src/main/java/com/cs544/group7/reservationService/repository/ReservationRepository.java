package com.cs544.group7.reservationService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cs544.group7.reservationService.domain.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	
	public Reservation findByReservationCode(String reservationCode);
	
	public List<Reservation> findByPassengerId(Long passengerId);

}
