package com.mycompany;

import com.mycompany.Operation;
import org.springframework.stereotype.Component;

@Component
class Multiplication implements Operation {

    @Override
    public int apply(int parm1, int parm2) {
        System.out.println("Multiplication = " + Integer.toString(parm1 * parm2));

        return parm1 * parm2;
        
    }

    @Override
    public boolean handles(char op) {
        return '*' == op;
    }
}