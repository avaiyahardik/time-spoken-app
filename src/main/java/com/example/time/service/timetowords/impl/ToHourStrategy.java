package com.example.time.service.timetowords.impl;

import com.example.time.service.timetowords.TimeToWordsStrategy;
import com.example.time.util.NumberToWordsUtil;

public class ToHourStrategy implements TimeToWordsStrategy {

    @Override
    public String convert(int hour, int minute) {
        int minutesTo = 60 - minute;
        String minuteWord = NumberToWordsUtil.minuteToWord(minutesTo);
        int nextHour = hour + 1;
        String hourWord = NumberToWordsUtil.hourToWord(nextHour % 12 == 0 ? 12 : nextHour % 12);
        return minuteWord + " to " + hourWord;
    }

}
