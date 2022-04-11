package com.example.tddyoutube.service;

import com.example.tddyoutube.model.Booking;
import com.example.tddyoutube.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;
    public int daysCalculatorWithDatabase(String name) {
        Optional<Booking> bookingOptional = bookingRepository.findByReserveName(name);

        return Period.between(bookingOptional.get().getCheckIn(), bookingOptional.get().getCheckOut()).getDays();
    }
}
