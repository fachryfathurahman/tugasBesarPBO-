/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysis;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;


/**
 *
 * @author fachry
 */
public class CandleIdentifiers extends Parent {
    private String typeCandle [];
    private double[] candleBody,upperShadow,lowerShadow;
    private final double MLT=1.3;
    private double averageCandleBody,sum=0;
    
    
    public void SearchTypeCandle(){
        typeCandle=new String[open.length];
        candleBody=new double[open.length];
        lowerShadow=new double[open.length];
        upperShadow=new double[open.length];
    NumberFormat format = NumberFormat.getInstance();
        for(int x=0;x<open.length;x++){


            if(open[x]>close[x]){

                candleBody[x]=open[x]-close[x];
                upperShadow[x]=high[x]-open[x];
                lowerShadow[x]=close[x]-low[x];
            }
            else if(open[x]<close[x]){
                candleBody[x]=close[x]-open[x];
                upperShadow[x]=high[x]-close[x];
                lowerShadow[x]=open[x]-low[x];
            }


            sum=sum+candleBody[x];

        }

        averageCandleBody=sum/open.length;

        for(int x=0;x<open.length;x++){
            if(open[x]>close[x]){
                if(candleBody[x]>=(MLT*averageCandleBody)&&upperShadow[x]<(1/MLT*averageCandleBody)&&
                        lowerShadow[x]<(1/MLT*averageCandleBody)&&upperShadow[x]!=0&&lowerShadow[x]!=0){
                    typeCandle[x]="long black candle";
                }
                else if((upperShadow[x]==0||lowerShadow[x]==0)&&candleBody[x]>(MLT*averageCandleBody)){
                    typeCandle[x]="black marubozu";
                }
                else if(candleBody[x]>=((1/MLT)*(1/MLT)*averageCandleBody)&&candleBody[x]<(1/MLT)*averageCandleBody&&
                            upperShadow[x]>candleBody[x]&&lowerShadow[x]>candleBody[x]){
                    typeCandle[x]="Spinning top";
                }
                else{
                    typeCandle[x]="black candle";
                }
            }
            else if (open[x]<close[x]){
                if(candleBody[x]>=(MLT*averageCandleBody)&&upperShadow[x]<(1/MLT*averageCandleBody)&&
                        lowerShadow[x]<(1/MLT*averageCandleBody)&&upperShadow[x]!=0&&lowerShadow[x]!=0){
                    typeCandle[x]="long white candle";
                }
                else if((upperShadow[x]==0||lowerShadow[x]==0)&&candleBody[x]>(MLT*averageCandleBody)){
                    typeCandle[x]="white marubozu";
                }

                else if(candleBody[x]>=((1/MLT)*(1/MLT)*averageCandleBody)&&candleBody[x]<(1/MLT)*averageCandleBody&&
                        upperShadow[x]>candleBody[x]&&lowerShadow[x]>candleBody[x]){
                    typeCandle[x]="Spinning top";
                }
                else{
                    typeCandle[x]="white candle";
                }
            }
            System.out.println(open[x]+"-"+close[x]);
            System.out.println(typeCandle[x]);

        }

    }

    public String[] getTypeCandle() {
        return typeCandle;
    }
    
    
}
