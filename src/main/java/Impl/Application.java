/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impl;

/**
 *
 * @author YNZ
 */
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import DataModel.YahooResponse;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private YahooResponse yahooResponse;

    public Application() {
        super();
    }

    public static void main(String args[]) {
        SpringApplication.run(Application.class, "USDEUR");

    }

    public static YahooResponse retrieve(String fxPair) {
        String env = "store://datatables.org/alltableswithkeys";
        String fmt = "json";
        String symbol = "'" + fxPair + "'";
        String queryStr = "select * from yahoo.finance.xchange where pair=";
        String baseUrl = "http://query.yahooapis.com/v1/public/yql?q=";
        String restUrl = baseUrl + "{queryStr}{symbol}&format={fmt}&env={env}";

        YahooResponse jsonResponse = null;

        try {
            RestTemplate restTemplate = new RestTemplate();
            jsonResponse = restTemplate.getForObject(restUrl, YahooResponse.class, queryStr, symbol, fmt, env);
        } catch (HttpClientErrorException e) {
            System.err.println("http client exception: " + e.getResponseBodyAsString() + " state code " + e.getStatusText());
        } catch (Exception e) {
            System.err.println("others: " + e.getMessage());
        }

        return jsonResponse;
    }

    @Override
    public void run(String... args) throws Exception {
        yahooResponse = retrieve("USDEUR");
        System.out.println("USDEUR" + yahooResponse.getFx());
    }

}
