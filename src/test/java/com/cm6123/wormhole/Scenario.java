package com.cm6123.wormhole;

import com.cm6123.wormhole.app.Application;
import com.cm6123.wormhole.board.Board;
import com.cm6123.wormhole.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Scenario {
    @Test //1
    @DisplayName("16 squares and no wormholes")
    public void BoardSize4() {
        Board testBoard = new Board(4);
        assertEquals(testBoard.getBoardSize(), 16);
        Player Player1 = new Player("player 1", true);
        Player1.manRollDice(3, 4);
        assertEquals(Player1.getBoardPosition(), 8);
        Player Player2 = new Player("it is now player 2's go...", false);
        assertFalse(Player2.getRoll());
    }

    @Test //2
    @DisplayName("Player 1 is the winner")
    public void BoardSize3() {
        Board testBoard = new Board(3);
        assertEquals(testBoard.getBoardSize(), 9);
        Player Player1 = new Player("player 1", true);
        Player1.manRollDice(5, 6);
        assertTrue(Player1.checkIfWon(9), "player 1 has won!");
    }

    @Test //3
    @DisplayName("25 squares with no wormholes and all players roll")
    public void BoardSize5P1() {
        Board testBoard = new Board(5);
        assertEquals(testBoard.getBoardSize(), 25);
        Player Player1 = new Player("player 1", true);
        assertTrue(Player1.getRoll());
        Player Player2 = new Player("player 2", false);
        assertFalse(Player2.getRoll());
    }

    @Test //4
    @DisplayName("25 squares with positive wormhole from square 7 to square 20")
    public void BoardSize5P2() {
        Board board = new Board(5);
        assertEquals(board.getBoardSize(), 25);
        Player Player1 = new Player("player 1", true);
        Player1.manRollDice(5, 1);
        assertEquals(Player1.getBoardPosition(), 7);
    }

    @Test //5
    @DisplayName("25 squares with negative wormhole from square 11 to square 2")
    public void BoardSize5P3() {
        Board testBoard = new Board(5);
        assertEquals(testBoard.getBoardSize(), 25);
        Player Player1 = new Player("player 1", true);
        Player1.manRollDice(6, 4);
        assertEquals(Player1.getBoardPosition(), 11);
    }

    @Test //6
    @DisplayName("25 squares with negative wormhole from square 11 to square 2")
    public void BoardSize5P4() {
        Board testBoard = new Board(5);
        assertEquals(testBoard.getBoardSize(), 25);
        Player Player1 = new Player("player 1", true);
        Player1.manRollDice(5, 5);
        assertEquals(Player1.getBoardPosition(), 11);
    }

    @Test //7
    @DisplayName("25 squares with positive wormhole from square 7 to square 2. all players roll")
    public void BoardSize5P5() {
        Board testBoard = new Board(5);
        assertEquals(testBoard.getBoardSize(), 25);
        Player Player2 = new Player("player 2", true);
        Player2.manRollDice(1, 1);
        assertEquals(Player2.getBoardPosition(), 3);
        Player Player3 = new Player("player 2", true);
        Player3.manRollDice(2, 3);
        assertEquals(Player3.getBoardPosition(), 6);
    }

    @Test //8
    public void BoardSize5P6() {
        Board testBoard = new Board(5);
        assertEquals(testBoard.getBoardSize(), 25);
        Player Player1 = new Player("player 1", true);
        Player1.manRollDice(4, 2);
        assertEquals(Player1.getBoardPosition(), 7);
        Player Player2 = new Player("player 2", true);
        Player2.manRollDice(1, 1);
        assertEquals(Player2.getBoardPosition(), 3);
    }

    @Test //video test
    @DisplayName("25 squares with positive wormhole from square 7 to square 20")
    public void BoardSize5P7() {
        Board board = new Board(5);
        assertEquals(board.getBoardSize(), 25);
        Player Player1 = new Player("player 1", true);
        Player1.manRollDice(5, 1);
        assertEquals(Player1.getBoardPosition(), 7);
    }
}
