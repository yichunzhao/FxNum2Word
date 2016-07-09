package CcyClient;

import DataModel.WorldCcy;
import DataModel.YahooResponse;
import Impl.Application;
import Impl.Number2Words;
import java.math.BigDecimal;

/**
 *
 * @author YNZ
 */
public class YahooCcyClient implements DeltekHomework{
   
    @Override
    public BigDecimal convert(BigDecimal amount, String sourceCurrency, String destinationCurrency) {
        if(!(WorldCcy.ccySet.contains(sourceCurrency)&&WorldCcy.ccySet.contains(destinationCurrency))){
            throw new IllegalArgumentException("Please use WorldCcy constants!");
        }
        
        StringBuilder sb = new StringBuilder();
        String ccyPairs = sb.append(sourceCurrency).append(destinationCurrency).toString();
        

        YahooResponse response = Application.retrieve(ccyPairs);
        System.out.println("response = " + response.getFx());
        
        BigDecimal newAmount= new BigDecimal("0");
        newAmount = amount.multiply(new BigDecimal(response.getFx()));

        return newAmount;
    }

    @Override
    public String toWords(BigDecimal number) {
        return Number2Words.Convert(number);
    }
    
}
