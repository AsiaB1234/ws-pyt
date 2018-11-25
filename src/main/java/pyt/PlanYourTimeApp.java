package pyt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class PlanYourTimeApp {

    public static void main(String[] args) {
        SpringApplication.run(PlanYourTimeApp.class, args);
    }
}
