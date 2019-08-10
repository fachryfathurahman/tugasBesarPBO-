/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bot.botapakah;

import analysis.CandlePrice;
import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.TickerPrice;
import java.util.List;

/**
 *
 * @author fachry
 */
public class tes {
    public static void main (String []args){
      keywordChecker cek = new keywordChecker("/analisis EOSETH");
      cek.cekKeyword();

        
      
    }
}
