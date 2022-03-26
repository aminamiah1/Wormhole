package com.cm6123.wormhole;

import com.cm6123.wormhole.app.Application;
import com.cm6123.wormhole.board.Board;
import com.cm6123.wormhole.player.Player;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardChecks {
    @Test
    public void createBoard() {
        Board testBoard = new Board(7);
        assertEquals(testBoard.getBoardSize(), 49);
    }

    @Test
    public void WormholesGenerator() {
        Board board = new Board(5);
        assertEquals(board.getBoardSize(), 25);
        board.wormholeGenerator();
        List<Integer> posEntrances = board.setWormholeEntrancesPositive();
        List<Integer> negEntrances = board.setWormholeEntrancesNegative();
        assertEquals(posEntrances.size() + negEntrances.size(), 5);
    }
    @Test
    public void ExitsGenerator() {
        Board board = new Board(5);
        assertEquals(board.getBoardSize(), 25);
        board.wormholeGenerator();
        List<Integer> Exits = board.setWormholeExits();
        assertEquals(Exits.size(), 5);
    }
}