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

    /**
     * Converts the given {@link LocalTime} into its British spoken time equivalent.
     *
     * @param time the time to convert, in 24-hour format
     * @return a {@link String} representing the spoken form of the time
     */
    @Override
    public String toSpokenTime(LocalTime time) {
        TimeToWordsStrategy strategy = timeToWordsFactory.getStrategy(time.getMinute());
        return strategy.convert(time.getHour(), time.getMinute());
    }

}
