package se.lexicon;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrencyConverterUI {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Starts the currency converter application.
     * Displays exchange rates and a menu for user interaction.
     */
    public static void start() {
        displayRates();  // Show the latest exchange rates
        int choice;
        do {
            displayMenu();  // Show the conversion options
            choice = getIntInput("Enter your choice: ");
            performOperations(choice);
        } while (choice != 0);
        System.out.println("Thank you for using the currency converter. Goodbye!");
        scanner.close();
    }

    /**
     * Displays the available currency conversion options.
     */
    public static void displayMenu() {
        System.out.println("\nCurrency Converter App:");
        System.out.println("1. Convert SEK to USD");
        System.out.println("2. Convert USD to SEK");
        System.out.println("3. Convert SEK to Euro");
        System.out.println("4. Convert Euro to SEK");
        System.out.println("0. Exit");
    }

    /**
     * Displays the latest exchange rates.
     */
    public static void displayRates() {
        System.out.println("----------------------------------------------");
        System.out.println("Exchange Rates as of " + LocalDate.now() + ":");
        System.out.println("1 SEK = " + CurrencyRates.SEK_TO_USD_RATE + " USD");
        System.out.println("1 USD = " + CurrencyRates.USD_TO_SEK_RATE + " SEK");
        System.out.println("1 SEK = " + CurrencyRates.SEK_TO_EURO_RATE + " EUR");
        System.out.println("1 EUR = " + CurrencyRates.EURO_TO_SEK_RATE + " SEK");
        System.out.println("----------------------------------------------");
    }

    /**
     * Executes currency conversion based on user input.
     *
     * @param operationNumber The menu option selected by the user.
     */
    public static void performOperations(int operationNumber) {
        double sekAmount, usdAmount, euroAmount;
        switch (operationNumber) {
            case 1:
                sekAmount = getAmount("SEK");
                usdAmount = CurrencyConverter.convertSekToUsd(sekAmount);
                displayConversionResult(sekAmount, usdAmount, "SEK", "USD");
                break;
            case 2:
                usdAmount = getAmount("USD");
                sekAmount = CurrencyConverter.convertUsdToSek(usdAmount);
                displayConversionResult(usdAmount, sekAmount, "USD", "SEK");
                break;
            case 3:
                sekAmount = getAmount("SEK");
                euroAmount = CurrencyConverter.convertSekToEuro(sekAmount);
                displayConversionResult(sekAmount, euroAmount, "SEK", "EUR");
                break;
            case 4:
                euroAmount = getAmount("EUR");
                sekAmount = CurrencyConverter.convertEuroToSek(euroAmount);
                displayConversionResult(euroAmount, sekAmount, "EUR", "SEK");
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    /**
     * Gets a valid currency amount from the user.
     * Ensures the input is a positive numeric value.
     *
     * @param currency The currency type (e.g., "SEK", "USD").
     * @return The valid amount entered by the user.
     */
    public static double getAmount(String currency) {
        double amount;
        while (true) {
            System.out.print("Enter amount in " + currency + ": ");
            try {
                amount = scanner.nextDouble();
                if (amount <= 0) {
                    System.out.println("Amount must be greater than zero.");
                } else {
                    return amount;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();  // Clear the invalid input
            }
        }
    }

    /**
     * Displays the result of a currency conversion.
     *
     * @param fromAmount  The original amount.
     * @param toAmount    The converted amount.
     * @param fromCurrency The original currency type.
     * @param toCurrency   The target currency type.
     */
    public static void displayConversionResult(double fromAmount, double toAmount, String fromCurrency, String toCurrency) {
        System.out.printf("\n%.2f %s is equal to %.2f %s\n", fromAmount, fromCurrency, toAmount, toCurrency);
    }

    /**
     * Safely gets an integer input from the user.
     *
     * @param message The message prompting the user for input.
     * @return The valid integer input.
     */
    private static int getIntInput(String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();  // Clear invalid input
            }
        }
    }
}
