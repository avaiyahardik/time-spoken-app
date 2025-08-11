package com.example.time.service.timetowords.impl;

import com.example.time.service.timetowords.TimeToWordsStrategy;
import com.example.time.util.NumberToWordsUtil;

public class ToHourStrategy implements TimeToWordsStrategy {

    /**
     * Converts the given hour and minute into a spoken British time format,
     * such as "quarter to five" or "ten minutes to two".
     *
     * @param hour   the hour component of the time (0–23)
     * @param minute the minute component (31–59)
     * @return a human-readable British spoken time string
     */
    @Override
    public String convert(int hour, int minute) {
        int minutesTo = 60 - minute;
        String minuteWord = NumberToWordsUtil.minuteToWord(minutesTo);
        int nextHour = hour + 1;
        String hourWord = NumberToWordsUtil.hourToWord(nextHour % 12 == 0 ? 12 : nextHour % 12);
        return minuteWord + " to " + hourWord;
    }

}
