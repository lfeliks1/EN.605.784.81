package app.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@SpringBootApplication
public class PropertyProfileApp {
    public static final void main(String...args) {

        new SpringApplicationBuilder(PropertyProfileApp.class)
                .profiles("north")
                .run(args).close();

    }        
}      


@Component
class ProfileManager implements CommandLineRunner {

      @Autowired
      private Environment environment;

    @Value("${message}")
    private String message;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*************" + "\n" + "Message: " + message);
        System.out.println("From ProfileManager,current active profiles are: " +
                Arrays.toString(environment.getActiveProfiles()) + "\n" + "*************");
            }
}

@Component
@Profile(value="east")
class BeanEast implements CommandLineRunner {

    @Value("${message}")
    private String message;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("*************" + "\n" + "Message: " + message);
        System.out.println("From BeanEast, in east environment" + "\n" + "*************");
    }
}

@Component
@Profile(value="west")
class BeanWest implements CommandLineRunner {

    @Value("${message}")
    private String message;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*************" + "\n" + "Message: " + message);
        System.out.println("From BeanWest, in west environment" + "\n" + "*************");
    }
}

@Component
@Profile(value={"default"})
class BeanDefault implements CommandLineRunner {

    @Value("${message}")
    private String message;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("*************" + "\n" + "Message: " + message);
        System.out.println("From BeanDefault, in default environment" + "\n" + "*************");
    }
}

