package app.demo.springbootpropertydemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import java.util.Map;

@Component
public class PropertyTypesExample implements CommandLineRunner {

    private final String stringParm;
    private final int intParm;
    private final boolean booleanParm;
    private final float floatParm;

    private final List<Integer> intListParm;
    private final int[] intArrayParm;
    private final Set<Integer> intSetParm;

    private final Map<Integer,String> mapParm;
    private final Map<String, String> systemProperties;

    private final List<Integer> intListDelimiterParm;

    public PropertyTypesExample(
            @Value("${arg.stringParm:EN605.784.81}") String parm,
            @Value("${arg.intParm:999}") int intParm,
            @Value("${arg.booleanParm:false}") boolean booleanParm,
            @Value("${arg.floatParm:55.66}") float floatParm,
            
            @Value("${arg.intListParm:}") List<Integer> intListParm,
            @Value("${arg.intSetParm:}") Set<Integer> intSetParm,
            @Value("${arg.intArrayParm:}") int[] intArrayParm,

            @Value("#{${arg.mapParm:{}}}") Map<Integer,String> mapParm,
            @Value("#{systemProperties}")  Map<String, String> systemProperties,
            
            @Value("#{'${arg.intListDelimiterParm:}'.split('@')}") List<Integer> intListDelimiterParm
            
            ) {
        
        this.stringParm = parm;
        this.intParm = intParm;
        this.booleanParm = booleanParm;
        this.floatParm = floatParm;   
    
        this.intListParm = intListParm;
        this.intSetParm = intSetParm;
        this.intArrayParm = intArrayParm;

        this.mapParm = mapParm;
        this.systemProperties = systemProperties;

        this.intListDelimiterParm = intListDelimiterParm;
    
    }      

    @Override
    public void run(String... args) throws Exception {
        System.out.println("stringParm=" + stringParm);
        System.out.println("intParm=" + intParm);
        System.out.println("booleanParm=" + booleanParm);
        System.out.println("floatParm=" + floatParm);

        System.out.println("intListParm=" + intListParm);
        System.out.println("intSetParm=" + intSetParm);
        System.out.println("intArrayParm=" + Arrays.toString(intArrayParm));

        System.out.println("map=" + mapParm);
        System.out.println("systemProperties[user.timezone]=" + systemProperties.get("user.timezone")); 
        System.out.println("systemProperties[java.runtime.version]=" + systemProperties.get("java.runtime.version")); 
        
        System.out.println("intListDelimeterParm=" + intListDelimiterParm);


    }
}
