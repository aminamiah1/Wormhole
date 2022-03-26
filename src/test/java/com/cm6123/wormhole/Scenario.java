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
        Board testBoard = new Board(5);
        testBoard.manualWormholeGenerator(7, 20, true);
        Player mark = new Player("Mark ", true);
        mark.manRollDice(3, 3);
        mark.wormholeChecker(testBoard);
        assertEquals(20, mark.getBoardPosition());
        Player Player1 = new Player("player 1 ", true);
        assertTrue(Player1.getRoll());
    }

    @Test //5
    @DisplayName("25 squares with negative wormhole from square 11 to square 2")
    public void BoardSize5P3() {
        Board testBoard = new Board(5);
        testBoard.manualWormholeGenerator(11, 2, false);
        Player carl = new Player("Mark ", true);
        carl.manRollDice(6, 4);
        carl.wormholeChecker(testBoard);
        assertEquals(2, carl.getBoardPosition());
        Player Player1 = new Player("player 1 ", true);
        assertTrue(Player1.getRoll());
    }

    @Test //6
    @DisplayName("25 squares with negative wormhole from square 11 to square 2")
    public void BoardSize5P4() {
        Board testBoard = new Board(5);
        testBoard.manualWormholeGenerator(11, 2, false);
        Player john = new Player("John ", true);
        john.manRollDice(5, 5);
        john.wormholeChecker(testBoard);
        assertEquals(2, john.getBoardPosition());
        Player Player1 = new Player("player 1 ", true);
        assertTrue(Player1.getRoll());
    }

    @Test //7
    @DisplayName("25 squares with positive wormhole from square 7 to square 20. all players roll")
    public void BoardSize5P5() {
        Board testBoard = new Board(5);
        testBoard.manualWormholeGenerator(7, 20, true);
        Player soumya = new Player("Soumya ", true);
        soumya.manRollDice(4, 2);
        soumya.wormholeChecker(testBoard);
        assertEquals(20, soumya.getBoardPosition());
        Player Player1 = new Player("Carl ", true);
        Player1.manRollDice(1, 1);
        assertEquals(Player1.getBoardPosition(), 3);
        soumya.manRollDice(2, 3);
        assertEquals(25, soumya.getBoardPosition());
        soumya.checkifWon();
    }

    @Test //8
    public void BoardSize5P6() {
        Board testBoard = new Board(5);
        testBoard.manualWormholeGenerator(7, 20, true);
        Player soumya = new Player("Soumya ", true);
        soumya.manRollDice(4, 2);
        soumya.wormholeChecker(testBoard);
        assertEquals(20, soumya.getBoardPosition());
        Player Player1 = new Player("Carl ", true);
        Player1.manRollDice(1, 1);
        assertEquals(Player1.getBoardPosition(), 3);
        soumya.manRollDice(3, 3);
        assertEquals(26, soumya.getBoardPosition());
        soumya.checkifWon();
    }

    @Test //Video Test
    public void shouldMoveToSpace20ForWormholeOn7() {
        Board testBoard = new Board(5);
        testBoard.manualWormholeGenerator(7, 20, true);
        Player robin = new Player("Robin", true);
        robin.manRollDice(5, 1);
        robin.wormholeChecker(testBoard);
        assertEquals(20, robin.getBoardPosition());
    }
}
