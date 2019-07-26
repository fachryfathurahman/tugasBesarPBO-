/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bot.botapakah;

import analysis.*;
import java.util.List;
import com.binance.api.client.domain.market.TickerPrice;

/**
 *
 * @author fachry
 */
public class keywordChecker extends Parent {
    private String[] keyword;
    private String jawaban;
    
    
    
    
    keywordChecker(String keyword){
        this.keyword=keyword.split(" ");
    }
    keywordChecker(){
        
    }
    
    public void cekKeyword(){
        if(keyword[0].equals("/analisis")){
            CandlePrice candle = new CandlePrice();
            candle.findPrice(keyword[1].toUpperCase());
            this.open=candle.getOpen();
            this.high=candle.getHigh();
            this.close=candle.getClose();
            this.low=candle.getLow();
            this.time=candle.getTime();
            
            CandleIdentifiers candleIdent = new CandleIdentifiers();
            candleIdent.setOpen(open);
            candleIdent.setClose(close);
            candleIdent.setHigh(high);
            candleIdent.setLow(low);
            candleIdent.setTime(time);
            
            
           TrendIdentifiers trend = new TrendIdentifiers();
            trend.findTrend(keyword[1].toUpperCase());
        }
        
    }
    
    public String getJawaban(){
        return jawaban;
    } 
    
    
}
