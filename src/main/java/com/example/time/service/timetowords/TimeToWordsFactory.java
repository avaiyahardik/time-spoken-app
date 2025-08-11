package com.example.time.service.timetowords;

import com.example.time.service.timetowords.impl.OnTheHourStrategy;
import com.example.time.service.timetowords.impl.PastHourStrategy;
import com.example.time.service.timetowords.impl.ToHourStrategy;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;

@Service
public class TimeToWordsFactory {

    /**
     * A map that defines which {@link TimeToWordsStrategy} to use
     * based on the minute value.
     */
    private static final Map<Function<Integer, Boolean>, TimeToWordsStrategy> STRATEGY_MAP = Map.of(
            (minute -> minute == 0), new OnTheHourStrategy(),
            (minute -> minute <= 30 && minute > 0), new PastHourStrategy(),
            (minute -> minute > 30 && minute < 60), new ToHourStrategy()
    );

    /**
     * Returns the appropriate {@link TimeToWordsStrategy} implementation
     * based on the number of minutes past the hour.
     *
     * @param minute the minute part of the time (0 to 59)
     * @return a {@link TimeToWordsStrategy} implementation suitable for the given minute
     * @throws IllegalArgumentException if no strategy matches the given minute
     */
    public TimeToWordsStrategy getStrategy(int minute) {
        return STRATEGY_MAP.entrySet().stream()
                .filter(entry -> entry.getKey().apply(minute))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No strategy found for minute: " + minute));
    }

}
