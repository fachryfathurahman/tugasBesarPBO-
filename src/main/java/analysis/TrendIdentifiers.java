/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysis;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.CandlestickInterval;
import java.util.List;

/**
 *
 * @author fachry
 */
public class TrendIdentifiers extends Parent {
    
    private long serverTime, startServerTime;
    private double sma5[], sma10[];
    String trend[];
    
    public void findTrend(String symbol){
         BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance();
        BinanceApiRestClient client = factory.newRestClient();
        serverTime = client.getServerTime();
        startServerTime = serverTime - 1728000000;
         List<Candlestick> candlesticks = client.getCandlestickBars(symbol, CandlestickInterval.DAILY, 50, startServerTime, serverTime);
        this.setRange(candlesticks.size());
        
        for(int i=0;i<candlesticks.size();i++){
            this.close[i] = Double.parseDouble(candlesticks.get(i).getClose());
        }
        sma5 = new double[close.length-5];
        sma10 = new double[close.length-10];
        for(int x=5;x<sma5.length+5;x++){
            sma5[x-5]=(close[x-1]+close[x-2]+close[x-3]+close[x-4]+close[x-5])/5;
        }
        for(int x=10;x<sma10.length+10;x++){
             sma10[x-10]=(close[x-1]+close[x-2]+close[x-3]+close[x-4]+close[x-5]
                     +close[x-6]+close[x-7]+close[x-8]+close[x-9]+close[x-10])/10;
        }
       
        trend = new String[sma10.length];
        int y=sma10.length-1,z=sma5.length-1;
        for(int x=0; x<sma10.length;x++){
            if(sma5[z]<sma10[y]){
                trend[x]="turun";
            }
            else if(sma5[z]>sma10[y]){
                trend[x]="naik";
            }
            else if(sma5[z]==sma10[y]){
                trend[x]="sideway";
            }
            y--;
            z--;
           
        }
    }
    public String[] getTrend(){
        return trend;
    }
}
