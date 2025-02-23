package com.lhind.repository.impl;

import com.lhind.model.entity.Booking;
import com.lhind.repository.BookingRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingRepositoryImpl implements BookingRepository {
    private List<Booking> bookings = new ArrayList<>();

    @Override
    public Optional<Booking> findById(Integer id) {
        return bookings.stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    @Override
    public List<Booking> findAll() {
        return new ArrayList<>(bookings);
    }

    @Override
    public void save(Booking booking) {
        bookings.add(booking);
    }

    @Override
    public void delete(Booking booking) {
        bookings.remove(booking);
    }
}
