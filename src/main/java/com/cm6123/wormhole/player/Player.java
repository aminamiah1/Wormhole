package com.cm6123.wormhole.player;

import javax.swing.text.Position;

public class Player {

    private int NumOfPlayers;
    public String name;
    public int AutoRoll;
    public int position;

    public Player(){
        name = " ";
        position = 1;
        AutoRoll = 0;
    }

    public String getPname(){
        return this.name;
    }
}
