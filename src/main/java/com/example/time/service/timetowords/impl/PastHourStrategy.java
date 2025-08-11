package com.example.time.service.timetowords.impl;

import com.example.time.service.timetowords.TimeToWordsStrategy;
import com.example.time.util.NumberToWordsUtil;

public class PastHourStrategy implements TimeToWordsStrategy {

    /**
     * Converts the given hour and minute into a spoken British time format,
     * such as "quarter past five" or "twenty past one".
     *
     * @param hour   the hour component of the time (0–23)
     * @param minute the minute component (1–30)
     * @return a human-readable British spoken time string
     */
    @Override
    public String convert(int hour, int minute) {
        String minuteWord = NumberToWordsUtil.minuteToWord(minute);
        String hourWord = NumberToWordsUtil.hourToWord(hour % 12 == 0 ? 12 : hour % 12);
        return minuteWord + " past " + hourWord;
    }

}
