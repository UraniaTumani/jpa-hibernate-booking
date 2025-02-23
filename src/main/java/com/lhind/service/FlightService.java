package com.lhind.service;

import com.lhind.model.entity.Flight;
import java.util.List;

public interface FlightService {
    void saveFlight(Flight flight);
    List<Flight> getAllFlights();
    void deleteFlight(Flight flight);
}
