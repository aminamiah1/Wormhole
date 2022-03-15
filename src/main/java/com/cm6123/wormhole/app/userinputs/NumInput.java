package com.cm6123.wormhole.app.userinputs;

public class NumInput extends UserInput {
    public Integer getInput(final String message, final Integer min, final Integer max){
        String WInput = "";
        Integer NInput = null;
        do{
            WInput = getUserInput(message);
            if(!(WInput.isEmpty())){
                if(!isNumeric(WInput)){
                    System.out.println("Numbers only. Try Again");
                }
                else{
                    NInput = Integer.parseInt(WInput);
                    if(NInput < min){
                        System.out.println("Unvalid. Lowest number you can go is " + min + ". Try Again.");
                    }
                    else if (NInput > max){
                        System.out.println("Unvalid. Highest number you can go is " + max + ". Try Again.");
                    }
                }
            }
        } while ((!isNumeric(WInput)) || (NInput < min) || (NInput > max) || (WInput.isEmpty()));
        return NInput;

    }

    public boolean isNumeric(final String StringCheck){
        if(StringCheck.isEmpty()){
            return false;
        }
        try{
            Integer.parseInt(StringCheck);
        } catch(NumberFormatException e){
            return false;
        }
        return true;
    }
}
