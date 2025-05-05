package app.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Profile;

@Component

@Profile ("east")

public class PropertyProfileExample implements CommandLineRunner {

    @Value("${app.commonProperty:undefined}")
    private String commonProperty;
    @Value("${app.appProperty:undefined}")
    private String appProperty;
    @Value("${app.defaultProperty:undefined}")
    private String defaultProperty;
    @Value("${app.eastProperty:undefined}")
    private String eastProperty;
    @Value("${app.westProperty:undefined}")
    private String westProperty;

    public void run(String... args) throws Exception {  
        
        System.out.println("*************************************" + "\n");

        System.out.println("commonProperty=" + commonProperty);
        System.out.println("appProperty=" + appProperty);
        System.out.println("defaultProperty=" + defaultProperty);
        System.out.println("eastProperty=" + eastProperty);
        System.out.println("westProperty=" + westProperty);

        System.out.println("\n" + "*************************************" );
    }
}