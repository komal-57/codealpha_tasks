import java.util.*;

public class Market {
    private Map<String, Stock> stockMap = new HashMap<>();

    public Market() {
        // Initial stock list
        addStock(new Stock("TCS", "Tata Consultancy", 3500));
        addStock(new Stock("INFY", "Infosys", 1450));
        addStock(new Stock("RELI", "Reliance", 2700));
    }

    public void addStock(Stock stock) {
        stockMap.put(stock.getSymbol(), stock);
    }

    public Stock getStock(String symbol) {
        return stockMap.get(symbol);
    }

    public void showMarket() {
        System.out.println("\nAvailable Stocks:");
        for (Stock stock : stockMap.values()) {
            System.out.println(stock);
        }
    }

    public void simulatePriceFluctuation() {
        Random rand = new Random();
        for (Stock stock : stockMap.values()) {
            double change = (rand.nextDouble() - 0.5) * 100;
            double newPrice = Math.max(1, stock.getPrice() + change);
            stock.updatePrice(Math.round(newPrice * 100.0) / 100.0);
        }
    }
}
