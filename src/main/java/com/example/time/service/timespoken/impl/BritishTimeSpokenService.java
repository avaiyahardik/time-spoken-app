package com.example.time.service.timespoken.impl;

import com.example.time.service.timetowords.TimeToWordsFactory;
import com.example.time.service.timespoken.TimeSpokenService;
import com.example.time.service.timetowords.TimeToWordsStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class BritishTimeSpokenService implements TimeSpokenService {

    private final TimeToWordsFactory timeToWordsFactory;

    @Override
    public String toSpokenTime(LocalTime time) {
        TimeToWordsStrategy strategy = timeToWordsFactory.getStrategy(time.getMinute());
        return strategy.convert(time.getHour(), time.getMinute());
    }

}
