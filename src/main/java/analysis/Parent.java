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
public class Parent {
    protected double[] open;
    protected double close[];
    protected double high[];
    protected double low[];
    protected Timestamp[] time;

    public void parent(double open[],double close[],double high[],double low[],Timestamp time[]){
        this.open=open;
        this.close=close;
        this.high=high;
        this.low=low;
        this.time=time;
    }
    public void parent(){
        
    }
    
    public void setRange(int range){
        open = new double[range];
        close = new double[range];
        high = new double[range];
        low = new double[range];
        time = new Timestamp[range];
    }

    public void setOpen(double[] open) {
        this.open = open;
    }

    public void setClose(double[] close) {
        this.close = close;
    }

    public void setHigh(double[] high) {
        this.high = high;
    }

    public void setLow(double[] low) {
        this.low = low;
    }

    public void setTime(Timestamp[] time) {
        this.time = time;
    }
    
    public double[] getOpen() {
        return open;
    }

    public double[] getClose() {
        return close;
    }

    public double[] getHigh() {
        return high;
    }

    public double[] getLow() {
        return low;
    }

    public Timestamp[] getTime() {
        return time;
    }
    
}
