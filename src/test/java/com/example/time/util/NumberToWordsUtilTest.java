package com.example.time.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberToWordsUtilTest {

    @Test
    @DisplayName("hourToWord should return correct word for valid hours")
    void testHourToWord_Valid() {
        assertThat(NumberToWordsUtil.hourToWord(1)).isEqualTo("one");
        assertThat(NumberToWordsUtil.hourToWord(12)).isEqualTo("twelve");
        assertThat(NumberToWordsUtil.hourToWord(0)).isEqualTo("");
    }

    @Test
    @DisplayName("hourToWord should throw exception for invalid hour")
    void testHourToWord_Invalid() {
        assertThatThrownBy(() -> NumberToWordsUtil.hourToWord(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid number for hour");

        assertThatThrownBy(() -> NumberToWordsUtil.hourToWord(13))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid number for hour");
    }

    @Test
    @DisplayName("minuteToWord should return 'quarter' for 15")
    void testMinuteToWord_Quarter() {
        assertThat(NumberToWordsUtil.minuteToWord(15)).isEqualTo("quarter");
    }

    @Test
    @DisplayName("minuteToWord should return 'half' for 30")
    void testMinuteToWord_Half() {
        assertThat(NumberToWordsUtil.minuteToWord(30)).isEqualTo("half");
    }

    @Test
    @DisplayName("minuteToWord should return 'one' for 1")
    void testMinuteToWord_OneMinute() {
        assertThat(NumberToWordsUtil.minuteToWord(1)).isEqualTo("one");
    }

    @Test
    @DisplayName("minuteToWord should return correct words for other minutes")
    void testMinuteToWord_OtherMinutes() {
        assertThat(NumberToWordsUtil.minuteToWord(2)).isEqualTo("two");
        assertThat(NumberToWordsUtil.minuteToWord(13)).isEqualTo("thirteen");
        assertThat(NumberToWordsUtil.minuteToWord(23)).isEqualTo("twenty three");
        assertThat(NumberToWordsUtil.minuteToWord(59)).isEqualTo("fifty nine");
    }

    @Test
    @DisplayName("minuteToWord should throw exception for invalid minutes")
    void testMinuteToWord_Invalid() {
        assertThatThrownBy(() -> NumberToWordsUtil.minuteToWord(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid number for minute");

        assertThatThrownBy(() -> NumberToWordsUtil.minuteToWord(60))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid number for minute");
    }
}