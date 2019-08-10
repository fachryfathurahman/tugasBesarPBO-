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
import com.binance.api.client.domain.market.TickerPrice;
import com.binance.api.client.domain.market.TickerStatistics;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author fachry
 */
public class CandlePrice extends Parent {

    private String price,jaw="";
    private long serverTime, startServerTime;
    private List<Candlestick> candlesticks;

    public void findPrice(String symbol) {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance();
        BinanceApiRestClient client = factory.newRestClient();

        serverTime = client.getServerTime();
        startServerTime = serverTime - 604800000;

       candlesticks = client.getCandlestickBars(symbol, CandlestickInterval.DAILY, 50, startServerTime, serverTime);

//        System.out.println(client.getAll24HrPriceStatistics().get(0).getPriceChangePercent());
//        System.out.println(client.getAllPrices().size());
        for(int i=0;i<100;i++){
            jaw+="/analisis"client.getAllPrices().get(i).getSymbol()+"\n";
        }
        this.setRange(candlesticks.size());
        for (int i = 0; i < candlesticks.size(); i++) {
            open[i] = Double.parseDouble(candlesticks.get(i).getOpen());
            close[i] = Double.parseDouble(candlesticks.get(i).getClose());
            high[i] = Double.parseDouble(candlesticks.get(i).getHigh());
            low[i] = Double.parseDouble(candlesticks.get(i).getLow());

            Timestamp ts = new Timestamp(candlesticks.get(i).getOpenTime());
            time[i]=ts;

            
        }
        

    }
    public String getJaw(){
        return jaw;
    }

}
