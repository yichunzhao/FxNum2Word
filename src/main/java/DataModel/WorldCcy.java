/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

import java.util.HashSet;

/**
 *
 * @author YNZ
 */
public class WorldCcy {
    public static final String GBP = "GBP";
    public static final String USD = "USD";
    public static final String EUR = "EUR";
    public static final String DKK = "DKK";
    public static final String CNY = "CNY";
    
    public static final HashSet<String> ccySet = new HashSet<>();
    
    static{
        ccySet.add(WorldCcy.CNY );
        ccySet.add(WorldCcy.USD);
        ccySet.add(WorldCcy.DKK);
        ccySet.add(WorldCcy.GBP);
        ccySet.add(WorldCcy.EUR);
    }
}
