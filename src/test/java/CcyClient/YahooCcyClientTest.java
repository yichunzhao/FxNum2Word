/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CcyClient;

import DataModel.WorldCcy;
import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author YNZ
 */
public class YahooCcyClientTest {

    private YahooCcyClient ccyClient;

    public YahooCcyClientTest() {
        ccyClient = new YahooCcyClient();
    }

    @Test
    public void testConvert() {
        BigDecimal amount = new BigDecimal("100");
        String sourceCurrency = WorldCcy.USD;
        String destinationCurrency = WorldCcy.DKK;
        BigDecimal newAmount = ccyClient.convert(amount, sourceCurrency, destinationCurrency);
        System.out.println("USD in DKK " + newAmount);
        assertNotEquals(new BigDecimal("0"), newAmount);
    }

    @Test
    public void testConvert1() {
        BigDecimal amount = new BigDecimal("100");
        String sourceCurrency = WorldCcy.GBP;
        String destinationCurrency = WorldCcy.USD;
        BigDecimal newAmount = ccyClient.convert(amount, sourceCurrency, destinationCurrency);
        System.out.println("GBP in USD " + newAmount);
        assertNotEquals(new BigDecimal("0"), newAmount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvert2() {
        BigDecimal amount = new BigDecimal("100");
        String sourceCurrency = "xxx";
        String destinationCurrency = WorldCcy.USD;
        BigDecimal newAmount = ccyClient.convert(amount, sourceCurrency, destinationCurrency);
    }

    @Test
    public void testToWords() {
        String expected ="one million, two hundred thirty-two thousand, four hundred fourteen and seventy-four thousand, seven hundred forty-six hundred-thousandths";
        String actual = ccyClient.toWords(new BigDecimal("1232414.74746"));
        assertEquals(expected, actual);
        
        
    }

}
