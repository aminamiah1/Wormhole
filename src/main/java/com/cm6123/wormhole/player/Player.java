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
     * The player if they landed on a wormhole.
     *
     * @param board
     * @return
     */
    public int wormholeChecker(final Board board) {
        ArrayList<Integer> wormholeEntrances = board.getWormholeEntrancesPositive();
        ArrayList<Integer> wormholeEntrances2 = board.getWormholeEntrancesNegative();
        ArrayList<Integer> wormholeExits = board.getWormholeExits();
        Random random = new Random();
        int randomIndex = random.nextInt(wormholeExits.size());

        if (wormholeEntrances.contains(boardPosition)) {
            int playerExit = (wormholeExits.get(randomIndex));
            do {
                boardPosition = playerExit;
                System.out.println(name + " landed on a POSITIVE wormhole!" + "\n" + name + " is now on " + playerExit);
            }
            while (playerExit > boardPosition);
        }

        if (wormholeEntrances2.contains(boardPosition)) {
            int playerExit = (wormholeExits.get(randomIndex));
            do{
                boardPosition = playerExit;
                System.out.println(name + " landed on a NEGATIVE wormhole!" + "\n" + name + " is now on " + playerExit);
            }
            while (playerExit < boardPosition);
        }
        return playerExit;
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

    /**
     * press enter to continue. nice feature.
     */
    public void responseWait() {
        System.out.println("Press Enter to continue...");
        sc.nextLine();
    }
}



