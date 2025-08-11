package com.example.time.service;

import com.example.time.service.timespoken.TimeSpokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class CommandLineService {

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("H:mm");

    private final TimeSpokenService timeSpokenService;

    /**
     * Starts the command-line interface to read user input, validate it,
     * and print the spoken time representation.
     *
     * @param in  the input stream to read user input (e.g., {@code System.in})
     * @param out the output stream to print results and messages (e.g., {@code System.out})
     */
    public void start(InputStream in, PrintStream out) {
        final Scanner scanner = new Scanner(in);
        out.println("\nEnter time in 24-hour format (HH:mm), or type 'exit' to quit:");
        while (true) {
            out.print("\nInput time: ");
            final String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                out.println("Exiting program. Goodbye!");
                break;
            }

            LocalTime localTime = parse24HourTime(input, out);
            if (localTime != null) {
                out.printf(" → %s%n", timeSpokenService.toSpokenTime(localTime));
            }
        }
    }

    /**
     * Parses the input string into a {@link LocalTime} using the expected 24-hour format.
     * If parsing fails, an error message is printed.
     *
     * @param inputTime the user input time string in HH:mm format
     * @param out       the output stream to print error messages
     * @return a {@link LocalTime} object if parsing is successful, or {@code null} if invalid
     */
    protected LocalTime parse24HourTime(String inputTime, PrintStream out) {
        LocalTime localTime = null;
        try {
            localTime = LocalTime.parse(inputTime, TIME_FORMATTER);
            return localTime;
        } catch (DateTimeParseException e) {
            out.println("❌ Invalid time format. Please use HH:mm (e.g., 13:45).");
        }
        return localTime;
    }
}
