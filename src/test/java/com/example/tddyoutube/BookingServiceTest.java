package com.example.tddyoutube;

import com.example.tddyoutube.model.Booking;
import com.example.tddyoutube.repository.BookingRepository;
import com.example.tddyoutube.service.BookingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

// Anotação para fazer um intermedio entre junit e o spring boot
@RunWith(SpringRunner.class)
public class BookingServiceTest {

    @TestConfiguration
    static class BookingServiceTestConfiguration {
        @Bean
        public BookingService bookingService() {
            return new BookingService();
        }
    }

    @Autowired
    BookingService bookingService;

    @MockBean
    BookingRepository bookingRepository;

    @Test
    public void bookinServiceDaysCalculator() {
        String name = "Ruan";
        int days = bookingService.daysCalculatorWithDatabase(name);
        Assertions.assertEquals(days, 12);
    }

    @Before
    public void setup () {
        LocalDate checkIn = LocalDate.parse("2022-04-08");
        LocalDate checkOut = LocalDate.parse("2022-04-20");
        Booking booking = new Booking("1", "Ruan", checkIn, checkOut, 2);

        Mockito.when(
                bookingRepository.findByReserveName(booking.getReserveName()))
                .thenReturn(Optional.of(booking));
    }
}
