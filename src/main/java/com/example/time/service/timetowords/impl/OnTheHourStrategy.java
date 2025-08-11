package com.example.time.service.timetowords.impl;

import com.example.time.service.timetowords.TimeToWordsStrategy;
import com.example.time.util.NumberToWordsUtil;

public class OnTheHourStrategy implements TimeToWordsStrategy {

    /**
     * Converts the given hour and minute (assumed to be zero) into
     * a spoken British time string.
     *
     * @param hour   the hour component (0–23)
     * @param minute the minute component (must be 0)
     * @return a human-readable spoken time string (e.g., "two o'clock", "midnight")
     */
    @Override
    public String convert(int hour, int minute) {
        return switch (hour) {
            case 0 -> "midnight";
            case 12 -> "noon";
            default -> {
                String hourWord = NumberToWordsUtil.hourToWord(hour % 12);
                yield hourWord + " o'clock";
            }
        };
    }

}
