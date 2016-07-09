/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

/**
 *
 * @author YNZ
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
    @JsonProperty("rate")
    private Rate rate;

    public Rate getRate() {
        return rate;
    }
    
    @JsonSetter("rate")
    public void setRate(Rate rate) {
        this.rate = rate;
    }
    
    @Override
    public String toString(){
        return rate.toString();
    }
}
