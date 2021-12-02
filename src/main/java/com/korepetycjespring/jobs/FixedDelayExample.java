package com.korepetycjespring.jobs;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

// https://www.baeldung.com/spring-scheduled-tasks
@Component
public class FixedDelayExample {

    /**
     * fixedDelay to czas w milisekundach, ktory musi uplynac po zakonczeniu metody process, przed jej ponownym uruchomieniem
     */
    //@Scheduled(fixedDelay = 2000, initialDelay = 5000) // fixedDelay - gwarantowany czas przerwy miedzy wywolaniami, initalDelay - czas ktory musi uplynac od startu aplikacji
    public void process() throws InterruptedException {
        System.out.println("Fixed delay start " + LocalDateTime.now());
        Thread.sleep(1000);
        System.out.println("Fixed delay end " + LocalDateTime.now());
    }

}
