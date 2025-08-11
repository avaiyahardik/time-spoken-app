package com.example.time;

import com.example.time.service.CommandLineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class TimeApplication implements CommandLineRunner {

    private final CommandLineService commandLineService;

    public static void main(String[] args) {
        SpringApplication.run(TimeApplication.class, args);
    }

    @Override
    public void run(String... args) {
        commandLineService.start(System.in, System.out);
    }
}
