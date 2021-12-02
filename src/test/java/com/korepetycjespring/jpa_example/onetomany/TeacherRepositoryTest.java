package com.korepetycjespring.jpa_example.onetomany;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
//@Transactional
class TeacherRepositoryTest {

    @Autowired
    TeacherRepository teacherRepository;

    @Test
    public void save_shouldSaveTeacherToDB(){
        //given
        Teacher teacher = Teacher.builder()
                .firstName("jan")
                .lastName("kowalski")
                .specialization(SpecializationEnum.MATH)
                .build();

        //when
        teacherRepository.save(teacher);
        //then
        assertThat(teacherRepository.findById(teacher.getId()).get()).isNotNull();
    }

}