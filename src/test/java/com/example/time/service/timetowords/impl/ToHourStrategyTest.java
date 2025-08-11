package com.example.time.service.timetowords.impl;

import com.example.time.service.timetowords.TimeToWordsStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ToHourStrategyTest {

    private TimeToWordsStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new ToHourStrategy();
    }

    @ParameterizedTest(name = "Should return {2} for {0}:{1}")
    @CsvSource({
            "11, 59, one to twelve",
            "11, 58, two to twelve",
            "11, 45, quarter to twelve",
            "00, 45, quarter to one",
            "23, 31, twenty nine to twelve",
            "00, 59, one to one",
            "1, 45, quarter to two",
            "1, 42, eighteen to two",
            "2, 59, one to three",
            "4, 55, five to five",
            "4, 40, twenty to five",
            "5, 45, quarter to six",
            "5, 55, five to six",
            "7, 40, twenty to eight",
            "7, 41, nineteen to eight",
            "11, 50, ten to twelve",
            "12, 59, one to one",
            "14, 45, quarter to three",
            "18, 49, eleven to seven",
            "12, 34, twenty six to one",
            "12, 45, quarter to one",
            "22, 53, seven to eleven",
            "22, 38, twenty two to eleven",
            "22, 50, ten to eleven",
            "23, 59, one to twelve"
    })
    @DisplayName("Should return to hour result")
    void testConvertToSpokenTime(int hour, int minute, String expectedTimeInWords) {
        assertThat(strategy.convert(hour, minute)).isEqualTo(expectedTimeInWords);
    }

}
