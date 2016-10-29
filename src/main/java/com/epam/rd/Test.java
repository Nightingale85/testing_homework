package com.epam.rd;



import com.epam.rd.enterprisecalc.Calculator;

import java.sql.SQLException;



/**
 * @author Sergiy_Solovyov
 */
public class Test {

    public  static void main(String[] args) throws SQLException, InterruptedException {

        Calculator calculator = new Calculator();
        Double evaluate = calculator.evaluate("8 + 8");
        System.out.println(evaluate);

    }
}
