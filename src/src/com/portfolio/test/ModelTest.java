package com.portfolio.test;

import com.portfolio.model.Transaction;
import com.portfolio.model.Holding;
import com.portfolio.model.Portfolio;
import java.time.LocalDate;

public class ModelTest {

    public static void main(String[] args) {
        System.out.println("=== TESTING MODEL CLASSES ===\n");

        // Test 1: Create a Transaction
        testTransaction();

        // Test 2: Create a Holding
        testHolding();

        // Test 3: Create a Portfolio
        testPortfolio();

        System.out.println("\n=== ALL TESTS PASSED! ===");
    }

    /**
     * Test Transaction class
     */
    public static void testTransaction() {
        System.out.println("TEST 1: Transaction");
        System.out.println("-------------------");

        Transaction tx = new Transaction(
                1,                          // id
                "user123",                  // userId
                "INFY",                     // symbol
                "BUY",                      // type
                10,                         // quantity
                1500.50,                    // pricePerUnit
                LocalDate.of(2024, 11, 1)  // tradeDate
        );

        System.out.println(tx);
        System.out.println("Total Value: ₹" + tx.getTotalValue());
        System.out.println("✓ Transaction created successfully\n");
    }

    /**
     * Test Holding class
     */
    public static void testHolding() {
        System.out.println("TEST 2: Holding");
        System.out.println("---------------");

        Holding holding = new Holding(
                "AAPL",        // symbol
                15,            // totalQuantity
                133.33,        // avgCost
                150.00         // currentPrice
        );

        System.out.println(holding);
        System.out.println("Total Invested: ₹" + holding.getTotalInvested());
        System.out.println("Current Value: ₹" + holding.getCurrentValue());
        System.out.println("Unrealized P/L: ₹" + holding.getUnrealizedPL());
        System.out.println("✓ Holding created successfully\n");
    }

    /**
     * Test Portfolio class
     */
    public static void testPortfolio() {
        System.out.println("TEST 3: Portfolio");
        System.out.println("-----------------");

        Portfolio portfolio = new Portfolio("user123");

        // Add some holdings
        Holding apple = new Holding("AAPL", 15, 133.33, 150.00);
        Holding infosys = new Holding("INFY", 10, 1500.00, 1550.00);

        portfolio.addHolding(apple);
        portfolio.addHolding(infosys);

        // Add some transactions
        Transaction tx1 = new Transaction(1, "user123", "AAPL", "BUY",
                10, 100.00, LocalDate.now());
        Transaction tx2 = new Transaction(2, "user123", "AAPL", "BUY",
                5, 200.00, LocalDate.now());

        portfolio.addTransaction(tx1);
        portfolio.addTransaction(tx2);

        // Print portfolio summary
        System.out.println(portfolio);
        System.out.println("Number of transactions: " + portfolio.getTransactions().size());
        System.out.println("✓ Portfolio created successfully\n");
    }
}