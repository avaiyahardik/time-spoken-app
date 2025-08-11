package com.example.time.service.timetowords.impl;

import com.example.time.service.timetowords.TimeToWordsStrategy;
import com.example.time.util.NumberToWordsUtil;

public class PastHourStrategy implements TimeToWordsStrategy {

    @Override
    public String convert(int hour, int minute) {
        String minuteWord = NumberToWordsUtil.minuteToWord(minute);
        String hourWord = NumberToWordsUtil.hourToWord(hour % 12 == 0 ? 12 : hour % 12);
        return minuteWord + " past " + hourWord;
    }

}
