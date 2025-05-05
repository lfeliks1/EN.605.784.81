package app.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PropertyTypesExample implements CommandLineRunner {

    private final String stringParm;

    public PropertyTypesExample (
        @Value("${arg.stringParm}") String parm
                                ) {
        this.stringParm = parm;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*************************************" + "\n" + "stringParm=" + 
        stringParm + "\n" + "*************************************" );
    }
}
