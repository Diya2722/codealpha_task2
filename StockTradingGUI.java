import javax.swing.*;
import java.awt.*;

public class StockTradingGUI extends JFrame {
    Portfolio portfolio = new Portfolio();

    Stock apple = new Stock("AAPL", 150);
    Stock google = new Stock("GOOG", 2800);
    Stock tesla = new Stock("TSLA", 700);

    JTextArea displayArea;
    JTextField qtyField;

    public StockTradingGUI() {
        setTitle("Stock Trading Platform");
        setSize(500, 500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        displayArea = new JTextArea(15, 40);
        add(new JScrollPane(displayArea));

        add(new JLabel("Quantity: "));
        qtyField = new JTextField(10);
        add(qtyField);

        JButton buyApple = new JButton("Buy AAPL");
        JButton sellApple = new JButton("Sell AAPL");

        JButton buyGoogle = new JButton("Buy GOOG");
        JButton sellGoogle = new JButton("Sell GOOG");

        JButton buyTesla = new JButton("Buy TSLA");
        JButton sellTesla = new JButton("Sell TSLA");

        JButton viewPortfolio = new JButton("View Portfolio");
        JButton saveButton = new JButton("Save Portfolio");

        add(buyApple);
        add(sellApple);
        add(buyGoogle);
        add(sellGoogle);
        add(buyTesla);
        add(sellTesla);
        add(viewPortfolio);
        add(saveButton);

        buyApple.addActionListener(e -> buyStock(apple));
        sellApple.addActionListener(e -> sellStock(apple));

        buyGoogle.addActionListener(e -> buyStock(google));
        sellGoogle.addActionListener(e -> sellStock(google));

        buyTesla.addActionListener(e -> buyStock(tesla));
        sellTesla.addActionListener(e -> sellStock(tesla));

        viewPortfolio.addActionListener(e -> showPortfolio());

        saveButton.addActionListener(e -> {
            FileManager.savePortfolio(portfolio);
            displayArea.setText("Portfolio Saved to File!");
        });

        setVisible(true);
    }

    private void buyStock(Stock stock) {
        int qty = Integer.parseInt(qtyField.getText());
        portfolio.buyStock(stock.getSymbol(), qty, stock.getPrice());
        displayArea.setText("Bought " + qty + " of " + stock.getSymbol());
    }

    private void sellStock(Stock stock) {
        int qty = Integer.parseInt(qtyField.getText());
        portfolio.sellStock(stock.getSymbol(), qty, stock.getPrice());
        displayArea.setText("Sold " + qty + " of " + stock.getSymbol());
    }

    private void showPortfolio() {
        displayArea.setText("Balance: " + portfolio.getBalance() + "\n");

        for (String key : portfolio.getStocks().keySet()) {
            displayArea.append(key + " : " + portfolio.getStocks().get(key) + "\n");
        }
    }

    public static void main(String[] args) {
        new StockTradingGUI();
    }
}
