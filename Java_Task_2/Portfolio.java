import java.util.*;

public class Portfolio {
    private Map<String, Integer> holdings = new HashMap<>();
    private double cash = 100000; // ₹1,00,000 starting cash

    public void buyStock(Stock stock, int quantity) {
        double totalCost = stock.getPrice() * quantity;
        if (totalCost <= cash) {
            holdings.put(stock.getSymbol(), holdings.getOrDefault(stock.getSymbol(), 0) + quantity);
            cash -= totalCost;
            System.out.println("✅ Bought " + quantity + " shares of " + stock.getSymbol());
        } else {
            System.out.println("❌ Not enough balance.");
        }
    }

    public void sellStock(Stock stock, int quantity) {
        String symbol = stock.getSymbol();
        int owned = holdings.getOrDefault(symbol, 0);
        if (owned >= quantity) {
            holdings.put(symbol, owned - quantity);
            cash += stock.getPrice() * quantity;
            System.out.println("✅ Sold " + quantity + " shares of " + symbol);
        } else {
            System.out.println("❌ You don't have enough shares.");
        }
    }

    public void showPortfolio(Market market) {
        System.out.println("\n📊 Portfolio:");
        double totalValue = cash;
        for (String symbol : holdings.keySet()) {
            Stock stock = market.getStock(symbol);
            int quantity = holdings.get(symbol);
            double value = quantity * stock.getPrice();
            totalValue += value;
            System.out.printf("%s: %d shares @ ₹%.2f = ₹%.2f%n", symbol, quantity, stock.getPrice(), value);
        }
        System.out.printf("💰 Cash: ₹%.2f%n", cash);
        System.out.printf("📈 Total Portfolio Value: ₹%.2f%n", totalValue);
    }
}
