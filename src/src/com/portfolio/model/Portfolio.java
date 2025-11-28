package com.portfolio.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Portfolio {
    private String userId;
    private Map<String, Holding> holdings;
    private List<Transaction> transactions;

    public Portfolio(String userId){
        this.userId = userId;
        this.holdings = new HashMap<>();
        this.transactions = new ArrayList<>();
    }

    public String getUserId(){
        return userId;
    }

    public Map<String,  Holding> getHoldings(){
        return holdings;
    }

    public List<Transaction> getTransactions(){
        return transactions;
    }

    public Holding getHolding(String symbol){
        return holdings.get(symbol);
    }

    public List<Holding> getAllHoldings(){
        return new ArrayList<>(holdings.values());
    }

    public void addHolding(Holding holding){
        holdings.put(holding.getSymbol(), holding);
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public double getTotalValue(){
        double total = 0;
        for (Holding holding : holdings.values()){
            total += holding.getCurrentValue();
        }
        return total;
    }

    public double getTotalInvested(){
        double total = 0;
        for (Holding holding : holdings.values()){
            total += holding.getTotalInvested();
        }
        return total;
    }

    public double getTotalUnrealizedPL(){
        return getTotalValue() - getTotalInvested();
    }

    public double getReturnPercentage(){
        if (getTotalInvested() == 0) return 0;
        return(getTotalUnrealizedPL()/getTotalInvested()) * 100;
    }

    public int getNumberOfStocks(){
        return holdings.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Portfolio for User: %s\n", userId));
        sb.append(String.format("Total Stocks: %d\n", getNumberOfStocks()));
        sb.append(String.format("Total Invested: ₹%.2f\n", getTotalInvested()));
        sb.append(String.format("Current Value: ₹%.2f\n", getTotalValue()));
        sb.append(String.format("Total P/L: ₹%.2f (%.2f%%)\n",
                getTotalUnrealizedPL(), getReturnPercentage()));
        sb.append("\nHoldings:\n");
        for (Holding holding : holdings.values()) {
            sb.append("  ").append(holding.toString()).append("\n");
        }
        return sb.toString();
    }

}
