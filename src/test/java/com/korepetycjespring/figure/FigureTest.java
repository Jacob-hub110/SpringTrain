package com.korepetycjespring.figure;

import com.korepetycjespring.KorepetycjeSpringApplication;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class FigureTest {

    @Test
    public void testRectangle() {
        //given
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(KorepetycjeSpringApplication.class);
        //when
        Rectangle rectangle = context.getBean(Rectangle.class);

        //then
        assertThat(rectangle.getFigureName()).isEqualTo("Rectangle");
    }

    @Test
    void testTriangle() {
        //given
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(KorepetycjeSpringApplication.class);
        //when
        final Triangle triangle = context.getBean(Triangle.class);

        //then
        assertThat(triangle.getFigureName()).isEqualTo("Triangle");
    }

    @Test
    void testCircle() {
        //given
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(KorepetycjeSpringApplication.class);
        //when
        final Figure figure = context.getBean(Circle.class);

        //then
        assertThat(figure.getFigureName()).isEqualTo("Circle");
    }
}