/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysis;

import java.sql.Timestamp;

/**
 *
 * @author fachry
 */
public class CandleIdentifiers extends Parent {
    private String typeCandle [];
    private double mlt=1.3;
    

    
    
    public void SearchTypeCandle(){
        typeCandle=new String[open.length];
        for(int x=0;x<open.length;x++){
            
        }
    }

    public String[] getTypeCandle() {
        return typeCandle;
    }
    
    
}
