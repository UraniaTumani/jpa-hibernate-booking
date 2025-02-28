package com.lhind.controller;

import com.lhind.model.entity.Flight;
import com.lhind.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(FlightController.FLIGHTS_BASE_PATH)
public class FlightController {

    static final String FLIGHTS_BASE_PATH = "/api/v1/flights";

    private final FlightService flightService;

    public FlightController(final FlightService flightService) {
        this.flightService = flightService;
    }


    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Flight>> getAllFlights() {
        return ResponseEntity.ok(flightService.getAllFlights());
    }

    @GetMapping(path = "/{flightId}", produces = "application/json")
    public ResponseEntity<Flight> getFlightById(@PathVariable("flightId") final Integer flightId) {
        Optional<Flight> flight = flightService.getFlightById(flightId);
        return flight.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Flight savedFlight = flightService.createFlight(flight);
        return ResponseEntity.ok(savedFlight);
    }


    @PutMapping(path = "/{flightId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Flight> updateFlight(@PathVariable("flightId") final Integer flightId,
                                               @RequestBody final Flight flight) {
        Optional<Flight> existingFlight = flightService.getFlightById(flightId);

        if (existingFlight.isPresent()) {
            Flight updatedFlight = existingFlight.get();
            updatedFlight.setOrigin(flight.getOrigin());
            updatedFlight.setDestination(flight.getDestination());
            updatedFlight.setAirline(flight.getAirline());
            updatedFlight.setFlightNumber(flight.getFlightNumber());
            updatedFlight.setDepartureDate(flight.getDepartureDate());
            updatedFlight.setArrivalDate(flight.getArrivalDate());
            updatedFlight.setStatus(flight.getStatus());

            Flight savedFlight = flightService.createFlight(updatedFlight);
            return ResponseEntity.ok(savedFlight);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping(path = "/{flightId}", produces = "application/json")
    public ResponseEntity<Void> deleteFlight(@PathVariable("flightId") final Integer flightId) {
        if (flightService.getFlightById(flightId).isPresent()) {
            flightService.deleteFlight(flightId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
