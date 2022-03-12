package com.cm6123.wormhole.app;

import com.cm6123.wormhole.dice.Dice;
import com.cm6123.wormhole.player.Player;
import com.cm6123.wormhole.board.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;

public final class Application {
    public static void main(final String[] args) {
        System.out.println("Welcome to Wormhole! \n " +
                "Rules: \n" +
                "~ 2 to 6 players allowed \n" +
                "~ auto roll or you can roll yourself \n" +
                "~ you start on tile 1 and you have to make your way to the end to win \n" +
                "~ watch out for the wormholes which can either send you backwards or forwards \n" +
                "~you get to choose how big you want the board and I will tell you where the wormholes are"); //beginning of board, welcomes you in, tells you the rules
        System.out.println("So to start, please enter the width dimension of your board"); //asks for the width of the board
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        while (true) {
            int BoardWidth;
            while(true){
                System.out.println("Please enter the width dimension of your board: ");
                try {
                    BoardWidth = Integer.parseInt(sc.nextLine());
                    if (BoardWidth >= 3 && BoardWidth <= 10) {
                        break;
                    } else {
                        System.out.println("Board width needs to be between 3 and 10");
                    }
                } catch (Exception e) {
                    System.out.println("Thank you");
                }
            }
        }
    }
}