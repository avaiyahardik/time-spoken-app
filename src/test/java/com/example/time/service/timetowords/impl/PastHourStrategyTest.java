package com.example.time.service.timetowords.impl;

import com.example.time.service.timetowords.TimeToWordsStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PastHourStrategyTest {

    private TimeToWordsStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new PastHourStrategy();
    }

    @ParameterizedTest(name = "Should return {2} for {0}:{1}")
    @CsvSource({
            "00, 01, one past twelve",
            "00, 02, two past twelve",
            "00, 15, quarter past twelve",
            "1, 15, quarter past one",
            "00, 30, half past twelve",
            "1, 01, one past one",
            "2, 15, quarter past two",
            "2, 30, half past two",
            "5, 05, five past five",
            "5, 29, twenty nine past five",
            "8, 20, twenty past eight",
            "12, 01, one past twelve",
            "12, 15, quarter past twelve",
            "12, 30, half past twelve",
            "13, 29, twenty nine past one",
            "23, 01, one past eleven",
            "23, 28, twenty eight past eleven",
            "23, 30, half past eleven"
    })
    @DisplayName("Should return past hour result")
    void testConvertToSpokenTime(int hour, int minute, String expectedTimeInWords) {
        assertThat(strategy.convert(hour, minute)).isEqualTo(expectedTimeInWords);
    }

}
