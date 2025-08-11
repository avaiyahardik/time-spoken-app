package com.example.time.service;

import com.example.time.service.timespoken.TimeSpokenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CommandLineServiceTest {

    @Mock
    private TimeSpokenService timeSpokenService;

    @InjectMocks
    private CommandLineService cli;

    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
    }

    @Test
    void testParseValidTime() {
        LocalTime time = cli.parse24HourTime("14:30", new PrintStream(outContent));
        assertThat(time).isEqualTo(LocalTime.of(14, 30));
    }

    @Test
    void testParseInvalidTime() {
        LocalTime time = cli.parse24HourTime("99:99", new PrintStream(outContent));
        assertThat(time).isNull();
        assertThat(outContent.toString()).contains("❌ Invalid time format");
    }

    @Test
    void testFullSessionWithValidAndExit() {
        String userInput = "14:15\nexit\n";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());

        cli.start(in, new PrintStream(outContent));

        String output = outContent.toString();
        verify(timeSpokenService).toSpokenTime(LocalTime.of(14, 15));
        assertThat(output).contains("Exiting program. Goodbye!");
    }

    @Test
    void testFullSessionWithInvalidAndExit() {
        String userInput = "hello\nexit\n";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());

        cli.start(in, new PrintStream(outContent));

        String output = outContent.toString();
        assertThat(output).contains("❌ Invalid time format");
        assertThat(output).contains("Exiting program. Goodbye!");
    }
}
