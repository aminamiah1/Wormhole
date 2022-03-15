package com.cm6123.wormhole.app.userinputs;

public class WordInput extends UserInput {

    public String getInput(final String message, final Integer maxLength) {
        String WInput = "";
        do {
            WInput = getUserInput(message);
            if (WInput.length() > maxLength) {
                System.out.println("Input too long. Try Again.");
            } else if (!Word(WInput)) {
                System.out.println("No numbers or special characters allowed.");
            }
        }
        while (WInput.length() > maxLength || !Word(WInput) || WInput.isEmpty());
            return WInput;
        }
        private boolean Word(final String StringCheck){
            return StringCheck != null && StringCheck.matches("^[a-zA-Z]*$");
        }
}
