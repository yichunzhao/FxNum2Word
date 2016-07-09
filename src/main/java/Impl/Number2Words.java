package Impl;



import DataModel.Places;
import java.math.BigDecimal;
import java.math.BigInteger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author YNZ
 */
public class Number2Words {

    public static String Big2Word(BigInteger num) {

        if (-1 == num.compareTo(B20)) {
            return ones[num.intValue()];
        }

        if (-1 == num.compareTo(B100)) {
            return tens[num.divide(B10).intValue()] + "-" + Number2Words.Big2Word(num.remainder(B10));
        }

        if (-1 == num.compareTo(B1T)) {
            return ones[num.divide(B100).intValue()] + " " + Places.HUNDREDS + " " + Number2Words.Big2Word(num.remainder(B100));
        }

        if (-1 == num.compareTo(B1M)) {
            return Number2Words.Big2Word(num.divide(B1T)) + " " + Places.THOUSANDS + ", " + Number2Words.Big2Word(num.remainder(B1T));
        }

        if (-1 == num.compareTo(B1B)) {
            return Number2Words.Big2Word(num.divide(B1M)) + " " + Places.MILLIONS + ", " + Number2Words.Big2Word(num.remainder(B1M));
        }

        if (-1 == num.compareTo(B1TR)) {
            return Number2Words.Big2Word(num.divide(B1B)) + " " + Places.BILLIONS + ", " + Number2Words.Big2Word(num.remainder(B1B));
        }

        return Number2Words.Big2Word(num.divide(B1TR)) + " " + Places.TRILLION + ", " + Number2Words.Big2Word(num.remainder(B1TR));
    }

    public static String Convert(BigDecimal num) {
        if (num == null) {
            throw new IllegalArgumentException("null input");
        }

        if (num.toPlainString().contains(".")) {
            String[] sNum = num.toPlainString().split("\\.");
            return Big2Word(new BigInteger(sNum[0])) + CONAND + Big2Word(new BigInteger(sNum[1])) + " " + decimalThs[sNum[1].length()];
        } else {
            return Big2Word(num.toBigInteger());
        }
    }

    public static String long2Word(long num) {
        if (num >= N1T * N1TR) {
            throw new IllegalArgumentException("don't handle numbers bigger than this now!");
        }

        if (num < 20) {
            return ones[(int) num];
        }

        if (num < N100) {
            return tens[(int) num / N10] + "-" + long2Word(num % N10);
        }

        if (num < N1T) {
            return ones[(int) num / N100] + " " + Places.HUNDREDS + " " + long2Word(num % N100);
        }

        if (num < N1M) {
            return long2Word(num / N1T) + " " + Places.THOUSANDS + ", " + long2Word(num % N1T);
        }

        if (num < N1B) {
            return long2Word(num / N1M) + " " + Places.MILLIONS + ", " + long2Word(num % N1M);
        }

        if (num < N1TR) {
            return long2Word(num / N1B) + " " + Places.BILLIONS + ", " + long2Word(num % N1B);
        }

        return long2Word(num / N1TR) + " " + Places.TRILLION + ", " + long2Word(num % N1TR);
    }

    private static final String ones[] = {"zero", "one", "two", "three", "four",
        "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen",
        "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String tens[] = {"", "", "twenty", "thirty", "forty", "fifty",
        "sixty", "seventy", "eighty", "ninety"};

    private static final String decimalThs[] = {"", "tenth", "hundredths", "thousandths",
        "ten-thousandths", "hundred-thousandths", "millionths", "ten-millionths", "hundred-millionths",
        "billionths", "ten-billionths", "hundred-billionths", "trillionths", "ten-trillionths", "hundred-trillionths"
    };

    private static final String CONAND = " and ";

    private static final int N10 = 10;
    private static final int N100 = 100;
    private static final int N1T = 1_000;
    private static final int N1M = 1_000_000;
    private static final int N1B = 1_000_000_000;
    private static final long N1TR = 1_000_000_000_000L;

    private static final BigInteger B10 = new BigInteger("10");
    private static final BigInteger B20 = new BigInteger("20");
    private static final BigInteger B100 = new BigInteger("100");
    private static final BigInteger B1T = new BigInteger("1000");
    private static final BigInteger B1M = new BigInteger("1000000");
    private static final BigInteger B1B = new BigInteger("1000000000");
    private static final BigInteger B1TR = new BigInteger("1000000000000");

}
