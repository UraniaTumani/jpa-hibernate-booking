package com.lhind.service;

import com.lhind.model.entity.Booking;
import java.util.List;

public interface BookingService {
    void saveBooking(Booking booking);
    List<Booking> getAllBookings();
    void deleteBooking(Booking booking);
}
