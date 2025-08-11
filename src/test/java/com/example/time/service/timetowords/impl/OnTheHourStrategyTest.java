package com.example.time.service.timetowords.impl;

import com.example.time.service.timetowords.TimeToWordsStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OnTheHourStrategyTest {

    private TimeToWordsStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new OnTheHourStrategy();
    }

    @ParameterizedTest(name = "Should return {2} for {0} hour")
    @CsvSource({
            "00, 00, midnight",
            "1, 00, one o'clock",
            "2, 00, two o'clock",
            "3, 00, three o'clock",
            "4, 00, four o'clock",
            "5, 00, five o'clock",
            "6, 00, six o'clock",
            "7, 00, seven o'clock",
            "8, 00, eight o'clock",
            "9, 00, nine o'clock",
            "10, 00, ten o'clock",
            "11, 00, eleven o'clock",
            "12, 00, noon",
            "13, 00, one o'clock",
            "14, 00, two o'clock",
            "15, 00, three o'clock",
            "16, 00, four o'clock",
            "17, 00, five o'clock",
            "18, 00, six o'clock",
            "19, 00, seven o'clock",
            "20, 00, eight o'clock",
            "21, 00, nine o'clock",
            "22, 00, ten o'clock",
            "23, 00, eleven o'clock"
    })
    @DisplayName("Should return exact hour result")
    void testConvertToSpokenTime(int hour, int minute, String expectedTimeInWords) {
        assertThat(strategy.convert(hour, minute)).isEqualTo(expectedTimeInWords);
    }

    @Test
    @DisplayName("Should return 'midnight' when hour is 0")
    void testConvert_Midnight() {
        assertThat(strategy.convert(0, 0)).isEqualTo("midnight");
    }

    @Test
    @DisplayName("Should return 'noon' when hour is 12")
    void testConvert_Noon() {
        assertThat(strategy.convert(12, 0)).isEqualTo("noon");
    }

    @Test
    @DisplayName("Should return correct o'clock for morning hour")
    void testConvert_RegularMorningHour() {
        assertThat(strategy.convert(9, 0)).isEqualTo("nine o'clock");
    }

    @Test
    @DisplayName("Should return correct o'clock for afternoon hour")
    void testConvert_RegularAfternoonHour() {
        assertThat(strategy.convert(15, 0)).isEqualTo("three o'clock"); // 3 PM
    }

    @Test
    @DisplayName("Should return correct o'clock for hour == 1")
    void testConvert_OneOClock() {
        assertThat(strategy.convert(1, 0)).isEqualTo("one o'clock");
    }

    @Test
    @DisplayName("Should return correct o'clock for hour == 13")
    void testConvert_ThirteenAsOneOClock() {
        assertThat(strategy.convert(13, 0)).isEqualTo("one o'clock");
    }
}
