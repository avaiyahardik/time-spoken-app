package com.example.time.service.timetowords;

import com.example.time.service.timetowords.impl.OnTheHourStrategy;
import com.example.time.service.timetowords.impl.PastHourStrategy;
import com.example.time.service.timetowords.impl.ToHourStrategy;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;

@Service
public class TimeToWordsFactory {

    private static final Map<Function<Integer, Boolean>, TimeToWordsStrategy> STRATEGY_MAP = Map.of(
            (minute -> minute == 0), new OnTheHourStrategy(),
            (minute -> minute <= 30 && minute > 0), new PastHourStrategy(),
            (minute -> minute > 30 && minute < 60), new ToHourStrategy()
    );

    public TimeToWordsStrategy getStrategy(int minute) {
        return STRATEGY_MAP.entrySet().stream()
                .filter(entry -> entry.getKey().apply(minute))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No strategy found for minute: " + minute));
    }

}
