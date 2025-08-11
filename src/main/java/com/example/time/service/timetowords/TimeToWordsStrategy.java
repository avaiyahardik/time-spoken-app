package com.example.time.service.timetowords;

public interface TimeToWordsStrategy {
    /**
     * Converts the given hour and minute into a spoken time string.
     *
     * @param hour   the hour value (0–23)
     * @param minute the minute value (0–59)
     * @return a human-readable spoken representation of the time
     */
    String convert(int hour, int minute);
}
