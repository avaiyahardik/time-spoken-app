package com.example.time.util;

public class NumberToWordsUtil {

    private static final String[] NUMBERS = {
            "", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] TENS = {
            "", "", "twenty", "thirty", "forty", "fifty"
    };

    private NumberToWordsUtil() {
    }

    public static String hourToWord(int hour) {
        if (hour < 0 || hour > 12) {
            throw new IllegalArgumentException("Invalid number for hour: " + hour);
        }
        return NUMBERS[hour];
    }

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

    public static String minuteToWord(int minute) {
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Invalid number for minute: " + minute);
        }
        if (minute == 15) return "quarter";
        if (minute == 30) return "half";
        return numberToWords(minute);
    }
}
