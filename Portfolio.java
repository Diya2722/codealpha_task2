import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private HashMap<String, Integer> stocks = new HashMap<>();
    private double balance = 100000;   // starting money

    public double getBalance() {
        return balance;
    }

    public HashMap<String, Integer> getStocks() {
        return stocks;
    }

    public void buyStock(String symbol, int qty, double price) {
        double total = qty * price;

        if(balance >= total) {
            balance -= total;
            stocks.put(symbol, stocks.getOrDefault(symbol, 0) + qty);
            System.out.println("Stock Bought Successfully!");
        } else {
            System.out.println("Not Enough balance!");
        }
    }

    public void sellStock(String symbol, int qty, double price) {
        if(stocks.containsKey(symbol) && stocks.get(symbol) >= qty) {
            balance += qty * price;
            stocks.put(symbol, stocks.get(symbol) - qty);
            System.out.println("Stock sold successfully");
        } else {
            System.out.println("not enough shares!");
        }
    }
}

