package com.cm6123.wormhole.app.userinputs;
import java.util.Scanner;

abstract class UserInput {
    protected String getUserInput(final String message){
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        String Input = sc.nextLine();
        return Input;
    }
}
