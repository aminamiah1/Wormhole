package com.cm6123.wormhole.app;

import com.cm6123.wormhole.dice.Dice;
import com.cm6123.wormhole.player.Player;
import com.cm6123.wormhole.board.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;

public final class Application {
    //create a logger for the class
    private static final Logger logger =
            LoggerFactory.getLogger(Application.class);
    private static int width;

    private Application() {
        CharSequence args = null;
        logger.info("Application Started with args:{}",
                String.join(".", args));
        Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to Wormhole! \n " +
                    "Rules: \n" +
                    "~ 2 to 6 players allowed \n" +
                    "~ auto roll or you can roll yourself \n" +
                    "~ you start on tile 1 and you have to make your way to the end to win \n" +
                    "~ watch out for the wormholes which can either send you backwards or forwards \n" +
                    "~you get to choose how big you want the board and I will tell you where the wormholes are"); //beginning of board, welcomes you in, tells you the rules
            System.out.println("So to start, please enter the width dimension of your board"); //asks for the width of the board
            int width = sc.nextInt();
        }
    }