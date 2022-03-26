package com.cm6123.wormhole.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Board {
    /**
     * This is board size and list of wormhole entrances and exits.
     */
    private final int boardSize;
    /**
     * This is board width.
     */
    private final int boardWidth;
    /**
     * This array stores the positive wormhole entrances.
     */
    private final ArrayList<Integer> wormholeEntrancesP = new ArrayList<Integer>();

    /**
     * This array stores negative wormhole entrances.
     */
    private final ArrayList<Integer> wormholeEntrancesN = new ArrayList<Integer>();
    /**
     * This array stores the wormhole exits.
     */
    private final ArrayList<Integer> wormholeExits = new ArrayList<Integer>();
    /**
     * This is board size and list of wormhole entrances and exits.
     */
    private final ArrayList<Integer> coin = new ArrayList<Integer>();
    /**
     * This string goes inside a hashmap because the pN changes from positive to negative.
     */
    private String pN;
    /**
     * Randomises wormholes.
     */
    private Random rdm = new Random();

    /**
     * creates board.
     *
     * @param userBoard
     */
    public Board(final int userBoard) {
        coin.add(-1);
        coin.add(1);
        this.boardWidth = userBoard;
        System.out.println("Creating a board...");
        boardSize = boardWidth * boardWidth;
        System.out.println("The board is " + boardSize + " squares");

    }

    /**
     * returns board size.
     *
     * @return boardSize
     */
    public int getBoardSize() {
        return boardSize;
    }

    /**
     * @return returns array list of positive wormholes.
     */
    public ArrayList<Integer> setWormholeEntrancesPositive() {
        return wormholeEntrancesP;
    }

    /**
     * @return Reutrns array list of negative wormholes.
     */
    public ArrayList<Integer> setWormholeEntrancesNegative() {
        return wormholeEntrancesN;
    }

    /**
     * @return Array list of wormhole exits.
     */
    public ArrayList<Integer> setWormholeExits() {
        return wormholeExits;
    }

    /**
     * Generates wormholes.
     */

    public void wormholeGenerator() {
        ArrayList<Integer> tempWormholeEntrances = new ArrayList<Integer>();
        for (int i = 2; i < boardSize - 1; i++) {
            tempWormholeEntrances.add(new Integer(i));
        }
        Collections.shuffle(tempWormholeEntrances);
        if (boardWidth % 2 == 0) {
            for (int i = 0; i < boardWidth / 2; i++) {
                wormholeEntrancesP.add(tempWormholeEntrances.get(i));
                tempWormholeEntrances.remove(i);
            }
            for (int i = 0; i < boardWidth / 2; i++) {
                wormholeEntrancesN.add(tempWormholeEntrances.get(i));
                tempWormholeEntrances.remove(i);
            }
        }
        if (boardWidth % 2 == 1) {
            for (int i = 0; i < (boardWidth / 2) + 1; i++) {
                wormholeEntrancesP.add(tempWormholeEntrances.get(i));
                tempWormholeEntrances.remove(i);
            }
            for (int i = 0; i < boardWidth / 2; i++) {
                wormholeEntrancesN.add(tempWormholeEntrances.get(i));
                tempWormholeEntrances.remove(i);
            }
        }
        for (int i = 0; i < boardWidth; i++) {
            wormholeExits.add(tempWormholeEntrances.get(i));
            tempWormholeEntrances.remove(i);
        }
    }

    /**
     * manual board so I can enter a number for the positive and negative wormholes.
     * @param wormholeNumber
     * @param exitNumber
     * @param isPositive
     */
    public void manualWormholeGenerator(final int wormholeNumber, final int exitNumber, final boolean isPositive) {
        // Way to manually create wormholes.
        ArrayList<Integer> tempWormholeEntrances = new ArrayList<Integer>();
        if (isPositive) {
            wormholeEntrancesP.add(wormholeNumber);
        } else {
            wormholeEntrancesN.add(wormholeNumber);
        }
        wormholeExits.add(exitNumber);

    }
}



