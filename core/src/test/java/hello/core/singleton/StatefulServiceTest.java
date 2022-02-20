package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulSerivceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService = ac.getBean(StatefulService.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);

        statefulService.order("userA", 10000);
        statefulService1.order("userB", 20000);

        int price = statefulService.getPrice();
        System.out.println(price);
        assertThat(statefulService.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}