package com.cm6123.wormhole.app.userinputs;

public class YesNo extends UserInput {
    public boolean getInput(final String message) {
        String Inputs = "";
        do {
            Inputs = getUserInput(message);
            if (Inputs.toLowerCase().equals("y")) {
                return true;
            } else if (Inputs.toLowerCase().equals("n")) {
                return false;
            } else {
                System.out.println("Unvalid response. Try Again.");
            }
        } while(true);
    }
}
