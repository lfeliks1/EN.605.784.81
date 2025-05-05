package com.mycompany;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class Calculator {

    private final Collection<Operation> operations;

    public Calculator(Collection<Operation> operations) {
        this.operations = operations;
    }

    public void calculate(int parm1, int parm2, char op) {

        for (  Operation oper : operations) {
            if (oper.handles(op)) {
                
                System.out.println("Input parameters = " + "....." + Integer.toString(parm1) + "........" + Integer.toString(parm2));

                int result = oper.apply(parm1, parm2);
                System.out.printf("%d %s %d = %s%n", parm1, op, parm2, result);
                return;
            }
        }
        throw new IllegalArgumentException("Unknown operation " + op);
    }
}