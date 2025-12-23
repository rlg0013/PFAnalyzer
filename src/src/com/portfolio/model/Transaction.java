package com.portfolio.model;

import java.time.LocalDate;

public class Transaction {


    private int id;
    private String userId;
    private String symbol;
    private String type;
    private int quantity;
    private double pricePerUnit;
    private LocalDate tradeDate;
    private String note;

    public Transaction(int id, String userId, String symbol, String type, int quantity, double pricePerUnit, LocalDate tradeDate){
        this.id = id;
        this.userId = userId;
        this.symbol = symbol;
        this.type = type;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.tradeDate = tradeDate;
        this.note = "";
    }

    public int getId(){
        return id;
    }

    public String getUserId(){
        return userId;
    }

    public String getSymbol(){
        return symbol;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note){
        this.note = note;
    }

    public double getTotalValue(){
        return quantity * pricePerUnit;
    }

    @Override
    public String toString() {
        return String.format("%s: %s %d shares of %s @ ₹%.2f on %s (Total: ₹%.2f)",
                type, type.equals("BUY") ? "Bought" : "Sold",
                quantity, symbol, pricePerUnit, tradeDate, getTotalValue());
    }
}
