package com.korepetycjespring.jpa_example.entity_example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@Transactional
class CarRepositoryTest {

    @Autowired
    CarRepository carRepository;

    @Test
    void shouldAddCar() {
        //given
        Car car = Car.builder()
                .brand("audi")
                .model("a8")
                .productionYear(LocalDate.of(2003, 9, 21))
                .creationDate(LocalDateTime.now())
                .build();
        //when
        this.carRepository.save(car);
        //then
        assertThat(this.carRepository.findById(car.getId())).isNotNull();
    }

}