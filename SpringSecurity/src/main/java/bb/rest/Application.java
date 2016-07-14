package bb.rest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by bartosz on 07.07.16.
 */
@SpringBootApplication(scanBasePackages = "bb")
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
//        for (String s : ctx.getBeanDefinitionNames())
//            System.out.println(s);

    }
}