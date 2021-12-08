package com.korepetycjespring.jpa_example.onetomany;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
        Student student1 = Student.builder()
                .firstName("Jan")
                .lastName("mat")
                .teacher(teacher)
                .build();
        Student student2 = Student.builder()
                .firstName("marek")
                .lastName("markowski")
                .teacher(teacher)
                .build();
        teacher.setStudents(List.of(student1, student2));

        //when
        teacherRepository.save(teacher);
        //then
        assertThat(teacherRepository.findById(teacher.getId()).get()).isNotNull();
    }

}