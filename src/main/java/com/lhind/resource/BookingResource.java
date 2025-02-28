package com.lhind.resource;

import java.time.LocalDate;

public record BookingResource(
        Integer id,
        LocalDate bookingDate,
        String status
) {
}




