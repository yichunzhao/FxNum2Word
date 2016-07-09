/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CcyClient;

import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author YNZ
 */
public class DeltekHomeworkTest {
    
    public DeltekHomeworkTest() {
    }

    @org.junit.Test
    public void testConvert() {
    }

    @org.junit.Test
    public void testToWords() {
    }

    public class DeltekHomeworkImpl implements DeltekHomework {

        @Override
        public BigDecimal convert(BigDecimal amount, String sourceCurrency, String destinationCurrency) {
            return null;
        }

        @Override
        public String toWords(BigDecimal number) {
            return "";
        }
    }
    
}
