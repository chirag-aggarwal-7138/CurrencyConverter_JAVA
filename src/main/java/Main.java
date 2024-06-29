import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter base currency: ");
            String baseCurrency = scanner.nextLine().toUpperCase();

            CurrencyConverter converter = new CurrencyConverter(baseCurrency);

            while (true) {
                System.out.print("Enter amount to convert: ");
                double amount = scanner.nextDouble();
                System.out.print("Enter source currency: ");
                String fromCurrency = scanner.next().toUpperCase();
                System.out.print("Enter target currency: ");
                String toCurrency = scanner.next().toUpperCase();

                double convertedAmount = converter.convert(fromCurrency, toCurrency, amount);
                System.out.printf("%.2f %s is %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);

                System.out.print("Do you want to convert another amount? (yes/no): ");
                String response = scanner.next().toLowerCase();
                if (!response.equals("yes")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error fetching exchange rates: " + e.getMessage());
        }
    }
}
