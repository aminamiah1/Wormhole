package com.cm6123.wormhole.app;

import com.cm6123.wormhole.app.Error.Error;
import com.cm6123.wormhole.board.Board;
import com.cm6123.wormhole.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
//import java.util.HashMap;
import java.util.Scanner;


public final class Application {
    /**
     * A few nice features, needed scanner for it.
     */

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    /**
     * makes application public.
     */
    public Application() {
    }

    /**
     * declares variables.
     *
     * @param args
     */
    public static void main(final String[] args) {
        int dice2;
        int dice1;
        Scanner usersInput = new Scanner(System.in);
        int playerNum;
        int boardSize;
        Boolean playAgain = false;
        Boolean gameWon = false;
        Error gameValidator = new Error();


        LOGGER.info("Application Started with args:{}", String.join(",", args));
        do {
            System.out.println("Welcome to Wormhole :) ");
            boardSize = gameValidator.userInt("\n Enter the width of your board(3 - 10): ", 3, 10);
            Board board = new Board(boardSize);
            if (boardSize > 4) {
                board.wormholeGenerator();
                System.out.println("\n ** Positive Wormhole entrances are: " + Arrays.asList(board.setWormholeEntrancesPositive()) + "**");
                System.out.println("** Negative Wormhole entrances are: " + Arrays.asList(board.setWormholeEntrancesNegative()) + "**");
                System.out.println("** Wormhole exits are: " + Arrays.asList(board.setWormholeExits()) + " **");
            } else {
                System.out.println("\n ** This board has no wormholes **");
            }

            playerNum = gameValidator.userInt("\n Please enter the amount of players (2 - 6): ", 2, 6);
            Player[] players = new Player[playerNum];
            for (int i = 0; i < playerNum; i++) {
                String playerName = gameValidator.usersWords("Enter player " + (i + 1) + " name:");
                boolean playerRolls = gameValidator.usersTrue("\n" + playerName + ", Do you want to roll your own dice or let me do it? Y to roll your own or N to let me do it");
                players[i] = new Player(playerName, playerRolls);
            }

            System.out.println("\n Let's Start! \n");
            for (int i = 0; i < players.length; i++) {
                System.out.println(players[i].playerPos() + "\n");
            }

            do {
                for (Player currentP : players) {
                    if (currentP.getRoll()) {
                        dice1 = gameValidator.userInt("\n" + currentP.playerName() + " Enter your first roll: ", 1, 6);
                        dice2 = gameValidator.userInt(currentP.playerName() + " Enter your second roll: ", 1, 6);
                        System.out.println(currentP.manRollDice(dice1, dice2));
                    } else {
                        System.out.println(currentP.rollDice());
                    }

                    if (currentP.getBoardPosition() >= board.getBoardSize()) {
                        gameWon = true;
                        System.out.println("\n ***" + currentP.playerName() + " has won! ***");
                        break;
                    }
                    currentP.wormholeChecker(board);
                    gameWon = currentP.checkIfWon(board.getBoardSize());
                }
            }
            while (!gameWon);
            playAgain = gameValidator.usersTrue("Do you want to play again? (Y/N)");
        }
        while (playAgain);
        LOGGER.info("Application Closing");
    }
}
