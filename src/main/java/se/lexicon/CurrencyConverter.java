package se.lexicon;

public class CurrencyConverter {

    // Converts an amount in SEK to USD using a predefined exchange rate.
    public static double convertSekToUsd(double sekAmount) {
        return sekAmount * CurrencyRates.SEK_TO_USD_RATE;
    }

    // Converts an amount in USD to SEK using a predefined exchange rate.
    public static double convertUsdToSek(double usdAmount) {
        return usdAmount * CurrencyRates.USD_TO_SEK_RATE;
    }

    // Converts an amount in SEK to Euro using a predefined exchange rate.
    public static double convertSekToEuro(double sekAmount) {
        return sekAmount * CurrencyRates.SEK_TO_EURO_RATE;
    }

    // Converts an amount in Euro to SEK using a predefined exchange rate.
    public static double convertEuroToSek(double euroAmount) {
        return euroAmount * CurrencyRates.EURO_TO_SEK_RATE;
    }

    /**
     * Converts currency based on the specified from and to currency codes.
     * It supports conversions between SEK, USD, and EUR.
     *
     * @param amount       The amount to convert.
     * @param fromCurrency The currency code of the input amount.
     * @param toCurrency   The currency code of the desired output.
     * @return The converted amount.
     * @throws IllegalArgumentException if the conversion type is unsupported.
     */
    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        if (fromCurrency.equalsIgnoreCase("SEK") && toCurrency.equalsIgnoreCase("USD")) {
            return convertSekToUsd(amount);
        } else if (fromCurrency.equalsIgnoreCase("USD") && toCurrency.equalsIgnoreCase("SEK")) {
            return convertUsdToSek(amount);
        } else if (fromCurrency.equalsIgnoreCase("SEK") && toCurrency.equalsIgnoreCase("EUR")) {
            return convertSekToEuro(amount);
        } else if (fromCurrency.equalsIgnoreCase("EUR") && toCurrency.equalsIgnoreCase("SEK")) {
            return convertEuroToSek(amount);
        } else {
            throw new IllegalArgumentException("Unsupported conversion: " + fromCurrency + " to " + toCurrency);
        }
    }
}
