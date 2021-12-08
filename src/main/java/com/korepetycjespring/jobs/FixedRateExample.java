package com.korepetycjespring.jobs;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration
@ConditionalOnProperty(value = "jobs.enabled", havingValue = "true", matchIfMissing = true)
public class FixedRateExample {

    private Integer threadCount = 0;

    /**
     * fixedRate to czas w milisekundach, ktory musi uplynac od uruchomienia metody process, przed jej ponownym uruchomieniem
     */
    @Scheduled(fixedRate = 1000) // czas przerwy miedzy wywolaniami liczony od startu
    @Async
    public void process() throws InterruptedException {
        System.out.println(++threadCount + " Fixed rate start " + LocalDateTime.now());
        Thread.sleep(10000);
        System.out.println(--threadCount + " Fixed rate end " + LocalDateTime.now());
    }

}
