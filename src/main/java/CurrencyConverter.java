import com.google.gson.JsonObject;

import java.io.IOException;

public class CurrencyConverter {
    private JsonObject exchangeRates;

    public CurrencyConverter(String baseCurrency) throws IOException {
        this.exchangeRates = ExchangeRateFetcher.fetchRates(baseCurrency);
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        double fromRate = exchangeRates.getAsJsonObject("rates").get(fromCurrency).getAsDouble();
        double toRate = exchangeRates.getAsJsonObject("rates").get(toCurrency).getAsDouble();
        return (amount / fromRate) * toRate;
    }
}
