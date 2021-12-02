package com.korepetycjespring.jpa_example.entity_example;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
