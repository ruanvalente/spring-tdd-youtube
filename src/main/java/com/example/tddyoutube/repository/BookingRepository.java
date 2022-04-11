package com.example.tddyoutube.repository;

import com.example.tddyoutube.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, String> {

    Optional<Booking> findByReserveName(String name);
}
