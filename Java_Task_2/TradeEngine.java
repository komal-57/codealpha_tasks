import java.util.Scanner;

public class TradeEngine {
    private Market market;
    private Portfolio portfolio;
    private Scanner scanner;

    public TradeEngine() {
        market = new Market();
        portfolio = new Portfolio();
        scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            market.simulatePriceFluctuation();
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    market.showMarket();
                    break;
                case 2:
                    buyStock();
                    break;
                case 3:
                    sellStock();
                    break;
                case 4:
                    portfolio.showPortfolio(market);
                    break;
                case 0:
                    System.out.println("Exiting. Happy Trading!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private void showMenu() {
        System.out.println("\n📍 STOCK TRADING MENU");
        System.out.println("1. View Market");
        System.out.println("2. Buy Stock");
        System.out.println("3. Sell Stock");
        System.out.println("4. View Portfolio");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private void buyStock() {
        System.out.print("Enter stock symbol to buy: ");
        String symbol = scanner.nextLine().toUpperCase();
        Stock stock = market.getStock(symbol);
        if (stock != null) {
            System.out.print("Enter quantity: ");
            int qty = scanner.nextInt();
            scanner.nextLine();
            portfolio.buyStock(stock, qty);
        } else {
            System.out.println("Invalid stock symbol.");
        }
    }

    private void sellStock() {
        System.out.print("Enter stock symbol to sell: ");
        String symbol = scanner.nextLine().toUpperCase();
        Stock stock = market.getStock(symbol);
        if (stock != null) {
            System.out.print("Enter quantity: ");
            int qty = scanner.nextInt();
            scanner.nextLine();
            portfolio.sellStock(stock, qty);
        } else {
            System.out.println("Invalid stock symbol.");
        }
    }
}
