import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    public static void savePortfolio(Portfolio portfolio) {
        try {
            FileWriter writer = new FileWriter("portfolio.txt");
            writer.write("Balance: " + portfolio.getBalance() + "\n");

            for(String key : portfolio.getStocks().keySet()) {
                writer.write(key + " : " + portfolio.getStocks().get(key) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
