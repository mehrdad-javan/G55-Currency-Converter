package se.lexicon;

public class ExchangeOperations {


    public static double convertSekToUsd(double sekAmount) { // 1000
        return sekAmount * ExchangeRates.SEK_TO_USD_RATE;
    }

    public static double convertUsdToSek(double usdAmount) {
        return usdAmount * ExchangeRates.USD_TO_SEK_RATE;
    }

    // todo: add more methods as needed


}
