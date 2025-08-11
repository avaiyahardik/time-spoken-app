package com.example.time.service.timetowords;

import com.example.time.service.timetowords.impl.OnTheHourStrategy;
import com.example.time.service.timetowords.impl.PastHourStrategy;
import com.example.time.service.timetowords.impl.ToHourStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class TimeToWordsFactoryTest {

    @InjectMocks
    private TimeToWordsFactory timeToWordsFactory;

    static IntStream pastMinutes() {
        return IntStream.rangeClosed(1, 30);
    }

    static IntStream toMinutes() {
        return IntStream.rangeClosed(31, 59);
    }

    @Test
    @DisplayName("Should return OnTheHourStrategy when minute is 0")
    void testOnTheHourStrategy() {
        TimeToWordsStrategy strategy = timeToWordsFactory.getStrategy(0);
        assertThat(strategy).isInstanceOf(OnTheHourStrategy.class);
    }

    @ParameterizedTest
    @MethodSource("pastMinutes")
    void testPastHourStrategy_FullRange(int minute) {
        TimeToWordsStrategy strategy = timeToWordsFactory.getStrategy(minute);
        assertThat(strategy).isInstanceOf(PastHourStrategy.class);
    }

    @ParameterizedTest
    @MethodSource("toMinutes")
    void testToHourStrategy_FullRange(int minute) {
        TimeToWordsStrategy strategy = timeToWordsFactory.getStrategy(minute);
        assertThat(strategy).isInstanceOf(ToHourStrategy.class);
    }

    @Test
    @DisplayName("Should throw exception for invalid minutes (< 0 or > 59)")
    void testInvalidMinuteThrowsException() {
        assertThatThrownBy(() -> timeToWordsFactory.getStrategy(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("No strategy found");

        assertThatThrownBy(() -> timeToWordsFactory.getStrategy(60))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("No strategy found");
    }
}
