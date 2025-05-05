package app.demo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class PropertyPlaceholderDemo {
	public static void main(String[] args) throws Exception {
	    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	    ctx.register(AppConfig.class);
	    ctx.refresh();    	
        ctx.registerShutdownHook();
	}
} 