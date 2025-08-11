package com.example.time.util;

public class NumberToWordsUtil {

    private static final int MAX_HOURS = 12;
    private static final int QUARTER_MINUTES = 15;
    private static final int HALF_HOUR_MINUTES = 30;

    private static final String[] NUMBERS = {
            "", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] TENS = {
            "", "", "twenty", "thirty", "forty", "fifty"
    };

    // Private constructor to prevent instantiation
    private NumberToWordsUtil() {
    }

    /**
     * Converts an hour integer (0-12) to its word representation.
     *
     * @param hour the hour value (0 to 12)
     * @return the English word for the given hour
     * @throws IllegalArgumentException if the hour is outside 0-12
     */
    public static String hourToWord(int hour) {
        if (hour < 0 || hour > MAX_HOURS) {
            throw new IllegalArgumentException("Invalid number for hour: " + hour);
        }
        return NUMBERS[hour];
    }

    // Helper method to convert numbers to words for 0-59
    private static String numberToWords(int number) {
        if (number < 20) {
            return NUMBERS[number];
        } else {
            int tens = number / 10;
            int ones = number % 10;
            return ones == 0
                    ? TENS[tens]
                    : TENS[tens] + " " + NUMBERS[ones];
        }
    }

    /**
     * Converts a minute integer (0-59) to its word representation.
     * Special cases for 15 ("quarter") and 30 ("half") are handled.
     *
     * @param minute the minute value (0 to 59)
     * @return the English word or phrase for the given minute
     * @throws IllegalArgumentException if the minute is outside 0-59
     */
    public static String minuteToWord(int minute) {
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Invalid number for minute: " + minute);
        }
        if (minute == QUARTER_MINUTES) return "quarter";
        if (minute == HALF_HOUR_MINUTES) return "half";
        return numberToWords(minute);
    }
}
