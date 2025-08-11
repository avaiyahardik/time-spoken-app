package com.example.time.service.timespoken;

import java.time.LocalTime;

public interface TimeSpokenService {
    /**
     * Converts the given {@link LocalTime} to a spoken time string.
     *
     * @param time the time to convert, must not be {@code null}
     * @return a human-readable spoken form of the time (e.g., "quarter past one")
     */
    String toSpokenTime(LocalTime time);
}
