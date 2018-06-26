package com.baotianqi.valpromise.bean;

/*
 *创建者：  hongjun
 *创建时间：2018/6/12 16:06
 *描述：   ${TODO}
 */public class CoinInfoBean {

    /**
     * time : 1528426413000
     * coin : btcusdt
     * price : 7672.12
     * timestamp : 1528426413150
     */

    private long time;
    private String coin;
    private double price;
    private long   timestamp;
    private String orderType;

    public String getOrderType () {
        return orderType;
    }

    public void setOrderType (String orderType) {
        this.orderType = orderType;
    }


    public long getTime () {
        return time;
    }

    public void setTime (long time) {
        this.time = time;
    }

    public String getCoin () {
        return coin;
    }

    public void setCoin (String coin) {
        this.coin = coin;
    }

    public double getPrice () {
        return price;
    }

    public void setPrice (double price) {
        this.price = price;
    }

    public long getTimestamp () {
        return timestamp;
    }

    public void setTimestamp (long timestamp) {
        this.timestamp = timestamp;
    }
}
