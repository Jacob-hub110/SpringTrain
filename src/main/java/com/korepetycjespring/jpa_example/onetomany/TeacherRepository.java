package com.korepetycjespring.jpa_example.onetomany;

import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {

}
