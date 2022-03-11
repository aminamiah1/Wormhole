package com.cm6123.wormhole.board;
import com.cm6123.wormhole.dice.Dice;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    private final ArrayList<Integer> LayoutOfBoard = new
            ArrayList<Integer>();
    private final ArrayList<Integer> Position = new
            ArrayList<Integer>();
    private int BoardSize = 0;

    private int[] wormholes;
    private int[] exit;

    public Board(final int BoardSize) {
        this.BoardSize = BoardSize;
        for (int index = 0; index < (this.BoardSize * this.BoardSize); index++) {
            LayoutOfBoard.add(index + 1);
        }
    }

    public ArrayList<Integer> getLayoutOfBoard() {
        return LayoutOfBoard;
    }

    public int[] AutoDiceRoll() {
        Random rd = new Random();
        int RandomInt1 = rd.nextInt(6);
        int RandomInt2 = rd.nextInt(6);
        if (RandomInt1 == 0) {
            RandomInt1++;
        }
        if (RandomInt2 == 0){
            RandomInt2++;
        }
        int[] DiceNum = new int[2];
        DiceNum[0] = RandomInt1;
        DiceNum[1] = RandomInt2;
        return DiceNum;
    }

    public void WormholesGenerator (final int width){
        Random rd = new Random();
        int temp = 0;
        wormholes = new int[width];
        for (int i = 0; i < width; i++){
            temp = 0;

            while (temp == 0 || temp == 1 || Position.contains(temp)){
                temp = rd.nextInt(width * width);
            }
            wormholes[i] = temp;
            Position.add(temp);
        }
    }

    public void ExitGenerator(final int width){
        Random rd = new Random();
        int temp = 0;
        exit = new int[width];
        for (int i =0; i < width; i++){
            temp = 0;
            while(temp == 0|| temp == 1|| Position.contains(temp)){
                temp = rd.nextInt(width * width);
            }
            exit[i] = temp;
            Position.add(temp);
        }
    }

    public void GetWormholes(){
        System.out.println("Wormholes: ");
        for (int i = 0; i < BoardSize; i++){
            System.out.println(wormholes[i] + " ");
        }
        System.out.println(" ");
    }

    public void getExit(){
        System.out.print("Exit: ");
        for (int i = 0; i < BoardSize; i++){
            System.out.print(exit[i] + " ");
        }
        System.out.println(" ");
    }

    public int ChecksWormhole(final int pos){
        for (int i: wormholes){
            if (pos == i){
                Random rd = new Random();
                int index = rd.nextInt(wormholes.length);
                System.out.println("wormhole at " + i);

                System.out.println("Exit at " + exit[index]);
                return exit[index];
            }
        }

        return pos;
    }

    public int[] getWormholes(){
        return getWormholes();
    }

    public int[] getExits(){
        return exit;
    }
}
