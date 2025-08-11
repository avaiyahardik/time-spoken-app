package com.example.time.service.timespoken.impl;

import com.example.time.service.timetowords.TimeToWordsFactory;
import com.example.time.service.timetowords.TimeToWordsStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BritishTimeSpokenServiceTest {

    @Mock
    private TimeToWordsFactory timeToWordsFactory;

    @InjectMocks
    private BritishTimeSpokenService britishTimeSpokenService;

    @Test
    @DisplayName("Should get time to words strategy from time to words factory and convert to british spoken time")
    void testToSpokenTimeCallsFactoryToGetStrategyAndConvertsTimeToWords() {
        LocalTime time = LocalTime.now();
        TimeToWordsStrategy strategy = mock(TimeToWordsStrategy.class);
        when(timeToWordsFactory.getStrategy(time.getMinute())).thenReturn(strategy);
        when(strategy.convert(time.getHour(), time.getMinute())).thenReturn("midnight");
        assertThat(britishTimeSpokenService.toSpokenTime(time)).isEqualTo("midnight");
        verify(strategy).convert(time.getHour(), time.getMinute());
    }

}
