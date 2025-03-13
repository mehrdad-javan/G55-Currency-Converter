package se.lexicon;

import java.time.LocalDate;
import java.util.Scanner;

public class ExchangeUI {
    // todo: needs completion


    public static void displayMenu() {
        System.out.println("Currency Converter App:");
        System.out.println("1. Convert SEK to USD");
        System.out.println("2. Convert USD to SEK");
        System.out.println("3. Convert SEK to Euro");
        System.out.println("4. Convert Euro to SEK");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }


    public static void displayRates() {
        System.out.println("----------------------------------------------");
        System.out.println("Exchange Rate as of " + LocalDate.now() + " :");
        System.out.println("## SEK = " + ExchangeRates.SEK_TO_USD_RATE + " USD");
        System.out.println("## USD = " + ExchangeRates.USD_TO_SEK_RATE + " SEK");
        System.out.println("## SEK = " + ExchangeRates.SEK_TO_EURO_RATE + " Euro");
        System.out.println("## Euro = " + ExchangeRates.EURO_TO_SEK_RATE + " SEK");
        System.out.println("----------------------------------------------");
    }

    public static void performOperations(int operationNumber) { // 1
        double sekAmount, usdAmount;

        switch (operationNumber) {
            case 1:
                sekAmount = getAmount("SEK");
                usdAmount = ExchangeOperations.convertSekToUsd(sekAmount);
                displayConversionResult(sekAmount, usdAmount, "SEK", "USD");
                break;
            case 2:
                usdAmount = getAmount("USD");
                sekAmount = ExchangeOperations.convertUsdToSek(usdAmount);
                displayConversionResult(usdAmount, sekAmount, "USD", "SEK");
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
                break;
        }

    }

    public static double getAmount(String currency) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount in " + currency + " : ");
        return scanner.nextDouble(); // 1000
    }

    public static void displayConversionResult(double fromAmount, double toAmount, String formCurrency, String toCurrency) {
        System.out.println(fromAmount + " " + formCurrency + " is = " + toAmount + " " + toCurrency);
    }

}
