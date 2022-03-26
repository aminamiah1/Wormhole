package com.cm6123.wormhole.player;

import com.cm6123.wormhole.board.Board;
import com.cm6123.wormhole.dice.Dice;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class Player {
    /**
     * scanner.
     */
    private final Scanner sc = new Scanner(System.in);
    /**
     * Player name.
     */
    private final String name;
    /**
     * finds exit depending on what kind of entrance they landed on.
     */
    private int playerExit;
    /**
     * value of manual Roll dice.
     */
    private final Boolean manRoll;
    /**
     * Players Board Position.
     */
    private int boardPosition;
    /**
     * player rolls dice.
     */
    private final Dice playerDice = new Dice(6);

    /**
     * manual roll for player.
     *
     * @param username
     * @param roll
     */
    public Player(final String username, final boolean roll) {
        this.name = username;
        this.manRoll = roll;
        boardPosition = 1;
    }

    /**
     * @return tells player to roll the dice.
     */
    @Override
    public String toString() {
        return "\n Player " + name + " Please roll the dice: " + manRoll + ".\n Currently in position " + boardPosition;
    }

    /**
     * @return tells what square the player is on.
     */
    public String playerPos() {
        return name + " is on square " + boardPosition;
    }

    /**
     * @return returns man roll.
     */
    public boolean getRoll() {
        return manRoll;
    }


    /**
     * @return rolls dice and tells players what they rolled.
     */
    public String rollDice() {
        int dice1 = playerDice.roll();
        int dice2 = playerDice.roll();
        boardPosition += dice1 + dice2;
        System.out.println("\n" + name + " rolled a " + dice1 + " and a " + dice2 + "\n"
                + name + " moves to square " + boardPosition);
        return "";
    }


    /**
     * @param dice1
     * @param dice2
     * @return adds the dice and tells the user what square.
     */
    public String manRollDice(final int dice1, final int dice2) {
        boardPosition += dice1 + dice2;
        System.out.println("\n" + name + " rolled a " + dice1 + " and a " + dice2 + "\n"
                + name + " moves to square " + boardPosition);
        return "";
    }

    /**
     * @param board
     * @return checks if player lands on wormhole and teleports them.
     */
    public int wormholeChecker(final Board board) {
        ArrayList<Integer> wormholeEntrancesP = board.setWormholeEntrancesPositive();
        ArrayList<Integer> wormholeEntrancesN = board.setWormholeEntrancesNegative();
        ArrayList<Integer> wormholeExits = board.setWormholeExits();
        Random random = new Random();
        boolean exitExists = false;
        boolean validExit = false;

        if (wormholeEntrancesP.contains(boardPosition)) {
            int posLow = boardPosition;
            for (int i = board.getBoardSize(); i > posLow; i--) {
                if (wormholeExits.contains(i)) {
                    exitExists = true;
                }
            }
                if (exitExists) {
                    while (validExit == false) {
                        int newPos = wormholeExits.get(random.nextInt(wormholeExits.size()));
                        if (newPos > posLow && wormholeExits.contains(newPos)) {
                            boardPosition = newPos;
                            System.out.println(name + " landed on a POSITIVE wormhole" + "\n"
                                    + name + " You are now on square " + newPos);
                            validExit = true;
                        }
                    }
                } else {
                    boardPosition = boardPosition;
                    System.out.println("luckily, there are no exits above you :) ");
                }
            }

        if (wormholeEntrancesN.contains(boardPosition)) {
            int posHigh = boardPosition;
            for (int i = 0; i < boardPosition; i++) {
                if (wormholeExits.contains(i)) {
                    exitExists = true;
                }
            }
            if (exitExists) {
                while (validExit == false) {
                    int newPos = wormholeExits.get(random.nextInt(wormholeExits.size()));
                    if (newPos < posHigh && wormholeExits.contains(newPos)) {
                        boardPosition = newPos;
                        System.out.println(name + " landed on a NEGATIVE wormhole" + "\n"
                                + name + " are now on square " + newPos);
                        validExit = true;
                    }
                }
            } else {
                boardPosition = boardPosition;
                System.out.println("luckily, there are no exits below you :) ");
            }
        }
        return 0;
    }

    /**
     * @param boardSize
     * @return checks if player won.
     */
    public Boolean checkIfWon(final int boardSize) {
        return boardPosition >= boardSize;
    }

    /**
     * @return returns player name.
     */
    public String playerName() {
        return name;
    }

    /**
     * @return returns boards position.
     */
    public int getBoardPosition() {
        return boardPosition;
    }
}




