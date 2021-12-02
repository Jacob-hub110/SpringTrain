package com.korepetycjespring;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShowBeansTest {

    /**
     * Test nie działa po dodaniu zależności Spring Jpa.
     */
    @Disabled
    @Test
    public void printBeans() {
        //given
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(KorepetycjeSpringApplication.class);

        System.out.println("[BEANS]");

        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        System.out.println("[END OF BEANS]");
    }

}
