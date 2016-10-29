package com.epam.rd;

import com.epam.rd.enterprisecalc.operations.basic.Add;
import com.epam.rd.enterprisecalc.operations.basic.Divide;
import com.epam.rd.enterprisecalc.operations.basic.Multiply;
import com.epam.rd.enterprisecalc.operations.basic.Subtract;
import com.epam.rd.enterprisecalc.operations.complex.RepeatedOperation;
import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sergiy_Solovyov
 */
public class RepeatedOperationTest {

    private RepeatedOperation  repeatedOperationMultiply;
    private RepeatedOperation  repeatedOperationAdd;
    private RepeatedOperation  repeatedOperationDivide;
    private RepeatedOperation  repeatedOperationSubtract;

    @Before
    public void set_up(){
        repeatedOperationMultiply = new RepeatedOperation(new Multiply(new Add()));
        repeatedOperationAdd = new RepeatedOperation(new Add());
        repeatedOperationSubtract = new RepeatedOperation(new Subtract());
        repeatedOperationDivide = new RepeatedOperation(new Divide());
    }

    @Test
    public void should_multiply_numbers(){
        assertEquals(new Double(216), repeatedOperationMultiply.apply(6D, 3));
    }

    @Test
    public void should_return__zero(){
        assertEquals(new Double(0), repeatedOperationMultiply.apply(6D, 0));
    }

    @Test
    public void should_add_numbers(){
        assertEquals(new Double(18), repeatedOperationAdd.apply(6D, 3));
    }

    @Test
    public void should_add_negative_numbers(){
        assertEquals(new Double(-18), repeatedOperationAdd.apply(-6D, 3));
    }

    @Test
    public void should_subtract_numbers(){
        assertEquals(new Double(-6), repeatedOperationSubtract.apply(6D, 3));
    }

    @Test
    public void should_subtract_negative_numbers(){
        assertEquals(new Double(6), repeatedOperationSubtract.apply(-6D, 3));
    }

    @Test
    public void should_divide_numbers(){
        assertEquals(new Double(0.125), repeatedOperationDivide.apply(8D, 3));
    }

    @Test
    public void should_divide_negative_numbers(){
        assertEquals(new Double(-0.125), repeatedOperationDivide.apply(-8D, 3));
    }

    @Test
    @Ignore("must be fixed in the next version")
    public void should_multiply_negative_numbers(){
        assertEquals(new Double(216), repeatedOperationMultiply.apply(-6D, 3));
    }

    @Test
    @Ignore("must be fixed in the next version - should throw exception")
    public void should_throw_exception(){
        repeatedOperationMultiply.apply(6D, -3);
    }
}
