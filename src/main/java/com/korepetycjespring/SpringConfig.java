package com.korepetycjespring;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling //adnotacja - umozliwia korzystanie ze schedulerow
@EnableAsync //adnotacja - wlacza asynchronicznosc, potrzebna do wykonywania kilku procesow Schedulera naraz
public class SpringConfig {
}
