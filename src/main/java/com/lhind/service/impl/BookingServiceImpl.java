package com.lhind.service.impl;
import java.util.Date;
import com.lhind.model.enums.BookingStatus;
import com.lhind.model.entity.Booking;
import com.lhind.repository.BookingRepository;
import com.lhind.service.BookingService;
import java.util.List;

public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void saveBooking(Booking booking) {
        if (booking.getBookingDate() == null) {
            booking.setBookingDate(new Date());
        }
        if (booking.getStatus() == null) {
            booking.setStatus(BookingStatus.BOOKED); //
        }
        bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public void deleteBooking(Booking booking) {
        bookingRepository.delete(booking);
    }
}
