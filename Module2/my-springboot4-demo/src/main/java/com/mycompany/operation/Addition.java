package com.mycompany;

import com.mycompany.Operation;
import org.springframework.stereotype.Component;

@Component
class Addition implements Operation {

    @Override
    public int apply(int parm1, int parm2) {
        System.out.println("Addition = " + Integer.toString(parm1) + 
        	               " ... " + Integer.toString(parm2) + 
        	               " ..." + Integer.toString(parm1 + parm2));

        return parm1 + parm2;
    }

    @Override
    public boolean handles(char op) {
        return '+' == op;
    }
}