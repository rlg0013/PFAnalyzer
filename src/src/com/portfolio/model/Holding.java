package com.portfolio.model;

public class Holding {
    private final String symbol;
    private int totalQuantity;
    private double avgCost;
    private double currentPrice;

    public Holding(String symbol){
        this.symbol = symbol;
        this.totalQuantity = 0;
        this.avgCost = 0.0;
        this.currentPrice = 0.0;
    }

    public Holding(String symbol, int totalQuantity, double avgCost, double currentPrice ){
        this.symbol = symbol;
        this.totalQuantity = totalQuantity;
        this.avgCost = avgCost;
        this.currentPrice = currentPrice;
    }

    public String getSymbol(){
        return symbol;
    }

    public int getTotalQuantity(){
        return totalQuantity;
    }

    public double getAvgCost(){
        return avgCost;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setTotalQuantity(int totalQuantity){
        this.totalQuantity = totalQuantity;
    }

    public void setAvgCost(double avgCost) {
        this.avgCost = avgCost;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getTotalInvested(){
        return totalQuantity * avgCost;
    }

    public double getCurrentValue(){
        return totalQuantity * currentPrice;
    }

    public double getUnrealizedPL(){
        return getCurrentValue() - getTotalInvested();
    }

    public double getPLPercentage(){
        if (getTotalInvested() == 0) return 0;
        return (getUnrealizedPL()/getTotalInvested()) * 100;
    }

    @Override
    public String toString(){
        return String.format("%s: %d shares | Avg Cost: ₹%.2f | Current: ₹%.2f | P/L: ₹%.2f (%.2f%%)",
                symbol, totalQuantity, avgCost, currentPrice,
                getUnrealizedPL(), getPLPercentage());
    }
}
