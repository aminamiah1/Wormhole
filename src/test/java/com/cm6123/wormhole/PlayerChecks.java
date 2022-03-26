package com.cm6123.wormhole;


import com.cm6123.wormhole.app.Application;
import com.cm6123.wormhole.board.Board;
import com.cm6123.wormhole.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerChecks {


    @Test
    public void testingWormholes(){
        Player player = new Player("player", true);
        Board testBoard = new Board(7);
        testBoard.wormholeGenerator();
        player.wormholeChecker(testBoard);
    }
}
