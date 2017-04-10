package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pyt.PlanYourTimeConfig;

@SpringBootApplication
@Import(PlanYourTimeConfig.class)
public class PlanYourTimeApp {

    public static void main(String[] args) {
        SpringApplication.run(PlanYourTimeApp.class, args);
    }
}

