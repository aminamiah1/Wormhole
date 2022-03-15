package com.cm6123.wormhole.player;

public class Player implements Comparable<Player> {

    private String playerName;
    private Boolean AutoRoll;
    private Integer position = 1;


    public Player(final String name) {
        this.playerName = name;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Boolean getAutoRoll() {
        return AutoRoll;
    }

    public Integer getPosition() {
        return position;
    }

    public void setAutoRoll(final Boolean rollPreference) {
        this.AutoRoll = rollPreference;
    }

    public void setPosition(final Integer newPosition) {
        if (newPosition > 0) {
            this.position = newPosition;
        } else {
            throw new ArithmeticException("A players position cannot be 0 or less");
        }
    }

    @Override
    public String toString() {
        return (getPlayerName() + " is on " + getPosition());
    }

    @Override
    public int compareTo(final Player o) {
        return this.getPlayerName().compareTo(o.getPlayerName());
    }
}



