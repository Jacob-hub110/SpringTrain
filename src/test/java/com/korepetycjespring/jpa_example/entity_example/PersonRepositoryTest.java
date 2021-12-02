package com.korepetycjespring.jpa_example.entity_example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
//@Transactional
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    void shouldAddPerson() {
        //given
        Person person = Person.builder()
                .firstName("Jan")
                .lastName("Nowak")
                .age(25)
                .creationDate(LocalDateTime.now())
                .build();
        //when
        this.personRepository.save(person);
        //then
        assertThat(this.personRepository.findById(person.getId()).get()).isNotNull();
    }
}