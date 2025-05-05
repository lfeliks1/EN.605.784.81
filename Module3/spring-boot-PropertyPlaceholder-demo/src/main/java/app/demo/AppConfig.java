package app.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
// @PropertySource("classpath:myApp.properties")      // - - - -  "static" declaration 
@PropertySource ("file:${app_home}/myApp.properties") // - - - - - "dynamic" declaration 

public class AppConfig {

	@Autowired
	Environment env;

	@Value("${myApp.url}")
	private String myAppUrl;
	@Value("${myApp.username}")
	 private String myAppusername;
	@Value("${myApp.password}")
	private String myApppassword;	

	@Bean
	public void dataProcess () {
		System.out.println("*********************************");				
		System.out.println("from Environment = " + env.getProperty("app.home"));	
		System.out.println(myAppUrl + "\n" + myAppusername + "\n" + myApppassword);
		System.out.println("*********************************");
	 }

	@Bean
	 public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	 }	 
 }
