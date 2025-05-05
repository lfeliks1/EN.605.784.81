package com.mycompany;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CalculatorApplication {
	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}
	@Bean
	public ApplicationRunner calculationRunner(Calculator calculator,
											   @Value("${parm1:6}") int parm1,
											   @Value("${parm2:8}") int parm2,
											   @Value("${op}") char op) {

		System.out.println ("app runner "+ parm1 + " ... " + parm2 + " ... " + op);
		return args -> calculator.calculate(parm1, parm2, op);
	}
}