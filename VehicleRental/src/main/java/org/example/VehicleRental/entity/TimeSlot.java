package org.example.VehicleRental.entity;

import org.example.VehicleRental.exception.InvalidInputException;

public class TimeSlot {
    private long startTime;
    private long endTime;

    public TimeSlot(long startTime, long endTime) {
        if (startTime >= endTime)
            throw new InvalidInputException("Invalid Vehicle TimeSlot input");
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getTimeUnits() {
        return this.endTime - this.startTime;
    }

    public boolean isOverLapping(TimeSlot timeSlot) {
        return (this.startTime <= timeSlot.endTime) && (this.endTime >= this.startTime);
    }
}
