package com.cm6123.wormhole.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {

    private Integer BoardSize;
    private List<Integer> wormholeEntrances;
    private List<Integer> wormholeExits;


    public Board(final Integer size) {
        if (size >= 5 & size <= 10){
            this.BoardSize = size;
        }else{
            throw new ArithmeticException("Invalid board width: can only be between 5 and 10");
        }
    }

    public List<Integer> getWormholeEntrances() {
        return wormholeEntrances;
    }

    public List<Integer> getWormholeExits() {
        return wormholeExits;
    }

    public void setWormholes() {

        /* initialise wormhole lists */

        this.wormholeEntrances = new ArrayList<Integer>();
        this.wormholeExits = new ArrayList<Integer>();

        /* generate potenial positions */

        List<Integer> BoardPosition = new ArrayList<Integer>();

        for (int i = 2; i < (this.BoardSize * this.BoardSize); i++) {
            BoardPosition.add(i);
        }

        Collections.shuffle(BoardPosition);

        for (int i = 1; i < (this.BoardSize * 2); i = i + 2) {
            this.wormholeEntrances.add(BoardPosition.get(i));
            this.wormholeExits.add(BoardPosition.get(i + 1));
        }

    }

    public Integer getRandomExit() {
        Double randomNumber = (Math.ceil(Math.random() * this.BoardSize - 1));
        Integer randomExit = this.wormholeExits.get(randomNumber.intValue());
        return randomExit;
    }

    public Integer getTotalPositions(){
        return this.BoardSize * this.BoardSize;
    }


    public boolean isWormhole(final Integer position) {
        if (getWormholeEntrances().contains(position)) {
            return true;
        }
        return false;
    }
}
