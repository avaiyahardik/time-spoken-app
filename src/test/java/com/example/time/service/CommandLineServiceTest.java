package com.example.time.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class CommandLineServiceTest {

    private CommandLineService cli;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        cli = new CommandLineService();
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
        assertThat(output).contains("✅ Valid 24-hour time: 14:15");
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
