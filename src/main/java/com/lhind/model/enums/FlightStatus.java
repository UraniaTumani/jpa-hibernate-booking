package com.lhind.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FlightStatus {
    SCHEDULED,
    DELAYED,
    CANCELLED;
}
