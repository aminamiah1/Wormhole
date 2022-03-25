package com.cm6123.wormhole;

import com.cm6123.wormhole.board.Board;
import com.cm6123.wormhole.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardChecks {
    @Test
    public void BoardSize4() {
        Board testBoard = new Board(4);
        assertEquals(testBoard.getBoardSize(), 16);
        Player Player1 = new Player("player 1", true);
        Player1.manRollDice(3, 4);
        assertEquals(Player1.getBoardPosition(), 8);
        Player Player2 = new Player("it is now player 2's go...", false);
        assertFalse(Player2.getRoll());
    }

    @Test
    public void BoardSize3() {
        Board testBoard = new Board(3);
        assertEquals(testBoard.getBoardSize(), 9);
        Player Player1 = new Player("player 1", true);
        Player1.manRollDice(4,4);
        assertTrue(Player1.checkIfWon(9));
    }

    @Test
    public void BoardSize5P1() {
        Board testBoard = new Board(5);
        assertEquals(testBoard.getBoardSize(), 25);
        Player Player1 = new Player("player 1", true);
        assertTrue(Player1.getRoll());
        Player Player2 = new Player("player 2", false);
        assertFalse(Player2.getRoll());
        }

    @Test
    public void BoardSize5P2() {
        Board testBoard = new Board(5);
        assertEquals(testBoard.getBoardSize(), 25);
        Player Player1 = new Player("player 1", true);
        Player1.manRollDice(4,2);
        assertEquals(Player1.getBoardPosition(),7);
    }

    @Test
    public void BoardSize5P3() {
        Board testBoard = new Board(5);
        assertEquals(testBoard.getBoardSize(), 25);
        Player Player1 = new Player("player 1", true);
        Player1.manRollDice(3,3);
        assertEquals(Player1.getBoardPosition(),7);
    }

    @Test
    public void BoardSize5P4() {
        Board testBoard = new Board(5);
        assertEquals(testBoard.getBoardSize(), 25);
        Player Player1 = new Player("player 1", true);
        Player1.manRollDice(5,4);
        assertEquals(Player1.getBoardPosition(),10);
    }

    @Test
    public void BoardSize5P5() {
        Board testBoard = new Board(5);
        assertEquals(testBoard.getBoardSize(), 25);
        Player Player1 = new Player("player 1", true);
        Player1.manRollDice(5,4);
        assertEquals(Player1.getBoardPosition(),10);
    }

    @Test
    public void BoardSize5P6() {
        Board testBoard = new Board(5);
        assertEquals(testBoard.getBoardSize(), 25);
        Player Player1 = new Player("player 1", true);
        Player1.manRollDice(4,2);
        assertEquals(Player1.getBoardPosition(),7);
        Player Player2 = new Player("player 2", true);
        Player2.manRollDice(1,1);
        assertEquals(Player2.getBoardPosition(),3);
    }
}
