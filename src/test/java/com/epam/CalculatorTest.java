package com.epam.rd;

import com.epam.rd.enterprisecalc.Calculator;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * @author Sergiy_Solovyov
 */
@RunWith(DataProviderRunner.class)
public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void set_up(){
        calculator = new Calculator();
    }

    @DataProvider
    public static Object[][] data() {
        return new Object[][] {
                { new Double(6.3), "3 + 3.3" },
                { new Double(2), "6 / 3" },
                { new Double(6), "9 - 3" },
                { new Double(30), "10 * 3" },
                { new Double(-7), "-3.5 + -3.5" },
                { new Double(2), "-6 / -3" },
                { Double.POSITIVE_INFINITY, "3 / 0"},
        };
    }
    @Test
    @UseDataProvider("data")
    public void testCalculator(final Double expected, final String input) {
        assertEquals(expected, calculator.evaluate(input));
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_many_elements(){
        calculator.evaluate("3 + 3 + 3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_few_elements(){
        calculator.evaluate(" + 3");
    }

    @Test(expected = NumberFormatException.class)
    public void should_throw_exception_letter(){
        calculator.evaluate("a + a");
    }

    @Test
    @Ignore("must be fixed in the next version")
    public void should_multiply_negative_numbers(){
        assertEquals(new Double(30), calculator.evaluate("-10 * -3"));
    }
}
