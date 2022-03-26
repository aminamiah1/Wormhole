package com.cm6123.wormhole.app.Error;

import java.util.Scanner;

public class Error {
    /**
     * @param message
     * @param minValue
     * @param maxValue
     * @return declares variables and sorts if an input is an error.
     */
    public int userInt(final String message, final int minValue, final int maxValue) {
        Scanner usersInput = new Scanner(System.in);
        String userInt;
        boolean gameValid = false;
        int errorInt = 0;
        do {
            System.out.println(message);
            userInt = usersInput.nextLine();
            try {
                errorInt = Integer.parseInt(userInt);
                if (errorInt >= minValue && errorInt <= maxValue) {
                    gameValid = true;
                } else {
                    System.out.println("** Enter a number within the said range. **");
                }
            } catch (NumberFormatException ex) {
                System.out.println("** Value not valid. **");
            }
        } while (!gameValid);
        return errorInt;
    }

    /**
     * @param message
     * @return declares variables and checks if input is an error.
     */
    public boolean usersTrue(final String message) {
        Scanner usersFactsCheck = new Scanner(System.in);
        String usersFacts;
        boolean gameValid = false;
        boolean usersChoice = false;
        do {
            System.out.println(message);
            usersFacts = usersFactsCheck.nextLine().toLowerCase();
            if (usersFacts.equals("y")) {
                usersChoice = true;
                gameValid = true;
            } else if (usersFacts.equals("n")) {
                usersChoice = false;
                gameValid = true;
            }
        } while (!gameValid);
        return usersChoice;
    }

    /**
     * @param message
     * @return declares variables and checks if users input is an error.
     */
    public String usersWords(final String message) {
        Scanner usersWordsCheck = new Scanner(System.in);
        String usersWords;
        boolean gameValid = false;
        do {
            System.out.println(message);
            usersWords = usersWordsCheck.nextLine();
        } while (usersWords.matches("[a-zA-Z]"));
        return usersWords;
    }
}
