package com.casamatechs.koreannumbers;

import com.casamatechs.koreannumbers.commons.Calculator;
import com.casamatechs.koreannumbers.commons.NumberType;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testCalculator1() {
        Assert.assertEquals("오백이십팔", Calculator.getResult(528, NumberType.SINO));
    }

    @Test
    public void testCalculator2() {
        Assert.assertEquals("십", Calculator.getResult(10, NumberType.SINO));
    }

    @Test
    public void testNativeCalculator() {
        Assert.assertEquals("오백스물여덟", Calculator.getResult(528, NumberType.NATIVE));
    }

    @Test
    public void testNativeCalculator2() {
        Assert.assertEquals("사백아홉", Calculator.getResult(409, NumberType.NATIVE));
    }

    @Test
    public void testNativeCalculator3() {
        Assert.assertEquals("백스물셋", Calculator.getResult(123, NumberType.NATIVE));
    }
}
