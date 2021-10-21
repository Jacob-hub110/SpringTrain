package com.korepetycjespring.film;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class FilmConfiguration {

    @Bean
    public Film matrix() {
        return new Film("Matrix", 120);
    }

    @Bean
    @Scope("singleton") //przy wstrzykiwaniu tego beana za kazdym razem otrzymamy ten sam obiekt, to ustawienie jest domyslne nie trzeba go pisac
    public Film titanic() {
        return new Film("Titanic", 115);
    }

    @Bean("puchatek")
    @Scope("prototype") //przy wstrzykiwaniu tego beana za kazdym razem otrzymamy nowy obiekt
    public Film kubusPuchatek() {
        return new Film("Kubus Puchatek", 20);
    }
}
