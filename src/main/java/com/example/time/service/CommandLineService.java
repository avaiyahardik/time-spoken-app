package com.example.time.service;

import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

@Service
public class CommandLineService {

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("H:mm");

    public void start(InputStream in, PrintStream out) {
        final Scanner scanner = new Scanner(in);
        out.println("Enter time in 24-hour format (HH:mm), or type 'exit' to quit:");
        while (true) {
            out.print("Input time: ");
            final String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                out.println("Exiting program. Goodbye!");
                break;
            }

            LocalTime localTime = parse24HourTime(input, out);
            if (localTime != null) {
                out.println("✅ Valid 24-hour time: " + input);
                // TODO Convert time to words here
            }
        }
    }

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
