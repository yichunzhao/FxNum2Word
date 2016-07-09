/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CcyClient;

import Impl.Number2Words;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author YNZ
 */
public class Number2WordsTest {

    public Number2WordsTest() {
    }

    @Test
    public void testConvert() {
        BigDecimal input = new BigDecimal("123.75");
        String expected = "one hundred twenty-three and seventy-five hundredths";
        String actual = Number2Words.Convert(input);
        assertEquals(actual, expected);
    }

    @Test
    public void testConvert1() {
        BigDecimal input = new BigDecimal("123.756");
        String expected = "one hundred twenty-three and seven hundred fifty-six thousandths";
        String actual = Number2Words.Convert(input);
        assertEquals(actual, expected);
    }

    @Test
    public void testConvert2() {
        BigDecimal input = new BigDecimal("343123.756656");
        String expected = "three hundred forty-three thousand, one hundred twenty-three and seven hundred fifty-six thousand, six hundred fifty-six millionths";
        String actual = Number2Words.Convert(input);
        assertEquals(actual, expected);
    }

    @Test
    public void testConvert3() {
        BigDecimal input = new BigDecimal("12343123.75665688");
        String expected = "twelve million, three hundred forty-three thousand, one hundred twenty-three and seventy-five million, six hundred sixty-five thousand, six hundred eighty-eight hundred-millionths";
        String actual = Number2Words.Convert(input);
        assertEquals(actual, expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvert4() {
        BigDecimal input = null;
        Number2Words.Convert(input);
    }
    
    @Test
    public void testConvert5() {
        BigDecimal input = new BigDecimal("12343123.756656896768");
        String expected = "twelve million, three hundred forty-three thousand, one hundred twenty-three and seven hundred fifty-six billion, six hundred fifty-six million, eight hundred ninety-six thousand, seven hundred sixty-eight trillionths";
        String actual = Number2Words.Convert(input);
        assertEquals(actual, expected);
    }

    @Test
    public void testLong2Word() {
        BigInteger input = new BigInteger("123");
        String expected = "one hundred twenty-three";
        String actual = Number2Words.Big2Word(input);
        assertEquals(actual, expected);
    }

    @Test
    public void testLong2Word1() {
        BigInteger input = new BigInteger("999");
        String expected = "nine hundred ninety-nine";
        String actual = Number2Words.Big2Word(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testLong2Word2() {
        BigInteger input = new BigInteger("998123");
        String expected = "nine hundred ninety-eight thousand, one hundred twenty-three";
        String actual = Number2Words.Big2Word(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testLong2Word3() {
        BigInteger input = new BigInteger("12348123");
        String expected = "twelve million, three hundred forty-eight thousand, one hundred twenty-three";
        String actual = Number2Words.Big2Word(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testLong2Word4() {
        BigInteger input = new BigInteger("5612348123");
        String expected = "five billion, six hundred twelve million, three hundred forty-eight thousand, one hundred twenty-three";
        String actual = Number2Words.Big2Word(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testLong2Word5() {
        BigInteger input = new BigInteger("9175612348123");
        String expected = "nine trillion, one hundred seventy-five billion, six hundred twelve million, three hundred forty-eight thousand, one hundred twenty-three";
        String actual = Number2Words.Big2Word(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testLong2Word6() {
        BigInteger input = new BigInteger("999175612348123");
        String expected = "nine hundred ninety-nine trillion, one hundred seventy-five billion, six hundred twelve million, three hundred forty-eight thousand, one hundred twenty-three";
        String actual = Number2Words.Big2Word(input);
        assertEquals(expected, actual);
    }

}
