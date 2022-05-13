package org.example.VehicleRental.entity;

import org.example.VehicleRental.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TimeSlotTest {
    @Test
    void timeSlotFailTest() {
        Assertions.assertThrows(InvalidInputException.class, () -> new TimeSlot(2, 1));
    }
}
