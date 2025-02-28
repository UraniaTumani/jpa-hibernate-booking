package com.lhind.service;

import com.lhind.model.entity.Booking;
import com.lhind.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;


    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }


    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);

        if (optionalBooking.isEmpty()) {
            return null;
        }

        Booking existingBooking = optionalBooking.get();
        existingBooking.setStatus(updatedBooking.getStatus());
        existingBooking.setBookingDate(updatedBooking.getBookingDate());
        existingBooking.setUser(updatedBooking.getUser());
        existingBooking.setFlight(updatedBooking.getFlight());

        return bookingRepository.save(existingBooking);
    }


    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
