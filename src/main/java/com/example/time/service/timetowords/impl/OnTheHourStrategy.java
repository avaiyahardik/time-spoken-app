package com.example.time.service.timetowords.impl;

import com.example.time.service.timetowords.TimeToWordsStrategy;
import com.example.time.util.NumberToWordsUtil;

public class OnTheHourStrategy implements TimeToWordsStrategy {

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
