package com.korepetycjespring.film;

import com.korepetycjespring.KorepetycjeSpringApplication;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FilmTest {

    @Test
    void testMatrix() {
        //given
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(KorepetycjeSpringApplication.class);
        //when
        final Film matrix = (Film) context.getBean("matrix");

        //then
        assertThat(matrix.getTitle()).isEqualTo("Matrix");
    }

    @Test
    void singletonScopeTest() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(KorepetycjeSpringApplication.class);

        final Film titanic = (Film) context.getBean("titanic");
        assertThat(titanic.getTitle()).isEqualTo("Titanic");

        titanic.setTitle("Titanic 2");

        final Film filmTitanic = (Film) context.getBean("titanic");
        assertThat(filmTitanic.getTitle()).isEqualTo("Titanic 2");
    }

    @Test
    void prototypeScopeTest() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(KorepetycjeSpringApplication.class);

        final Film titanic = (Film) context.getBean("puchatek");
        assertThat(titanic.getTitle()).isEqualTo("Kubus Puchatek");

        titanic.setTitle("Conan Barbarzynca");

        final Film filmTitanic = (Film) context.getBean("puchatek");
        assertThat(filmTitanic.getTitle()).isEqualTo("Kubus Puchatek");
    }
}