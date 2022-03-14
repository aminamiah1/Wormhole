package com.cm6123.wormhole.app;

import com.cm6123.wormhole.dice.Dice;
import com.cm6123.wormhole.player.Player;
import com.cm6123.wormhole.board.Board;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Application {
    public static void main(final String[] args) {
        System.out.println("Welcome to Wormhole! \n " +
                "Rules: \n" +
                "~ 2 to 6 players allowed \n" +
                "~ auto roll or you can roll yourself \n" +
                "~ you start on tile 1 and you have to make your way to the end to win \n" +
                "~ watch out for the wormholes which can either send you backwards or forwards \n" +
                "~you get to choose how big you want the board and I will tell you where the wormholes are"); //beginning of board, welcomes you in, tells you the rules
        System.out.println("So to start, please enter the width dimension of your board"); //asks for the width of the board
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        while (true) {
            int BoardWidth;
            while (true){
                System.out.println("Please enter the width dimension of your board: ");
                try {
                    BoardWidth = Integer.parseInt(sc.nextLine());
                    if (BoardWidth >= 3 && BoardWidth <= 10) {
                        break;
                    } else {
                        System.out.println("Board width needs to be between 3 and 10");
                    }
                } catch (Exception e) {
                    System.out.println("Numbers only");
                    System.out.println("Press Enter ");
                    sc.nextLine();
                }
            }

            System.out.println("Thank you.");
            Board bd = new Board(BoardWidth);
            bd.WormholesGenerator(BoardWidth);
            bd.ExitGenerator(BoardWidth);
            System.out.println("This Board has " + BoardWidth * BoardWidth + " squares.");
            bd.getWormholes();
            bd.getExits();

            int NumOfPlayers;
            while (true) {
                try {
                    System.out.println("Please enter the number of players: ");
                    NumOfPlayers = Integer.parseInt(sc.nextLine());
                    if (NumOfPlayers >= 2 && NumOfPlayers <= 6) {
                        System.out.println("There are " + (NumOfPlayers) + " players.");
                        break;
                    } else {
                        System.out.println("Number needs to be between 2 and 6");
                    }
                } catch (Exception e) {
                    System.out.println("Numbers only");
                }
            }

            Player[] players;
            players = new Player[NumOfPlayers];
            for (int i = 0; i < NumOfPlayers; i++) {
                while (true) {
                    try {
                        System.out.println("Enter Player " + (i + 1) + " name: ");
                        players[i] = new Player();
                        players[i].name = sc.nextLine();
                        Pattern p = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE);
                        Matcher m = p.matcher(players[i].name);
                        boolean checker = m.find();
                        if (checker) {
                            System.out.println("Name can not contain any numbers, special characters or spaces. Try again.");
                            continue;
                        }
                        int NameTaken = 0;
                        for (int a = 0; a < i; a++) {
                            if (players[a].name.equals(players[i].name)) {
                                System.out.println("Name is already taken. Try again.");
                                NameTaken = 1;
                            }
                        }
                        if (NameTaken == 1) ;
                        continue;

                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    if (players[i].name.length() > 10) {
                        System.out.println("Player name can not exceed 10 letters. \n" +
                                "Use first name only. \n " +
                                "If there is players with the same name, " +
                                "add last name initals. For example, JohnS");
                    } break;
                }
            }

            for (int i = 0; i < NumOfPlayers; i++) {
                System.out.println(players[i].name);
            }
            String YesNo = new String();
            for (int i = 0; i < NumOfPlayers; i++) {
                while (true) {
                    System.out.println(players[i].name + "do you want to roll the dice, or shall I do it for you? \n Type Y to roll" +
                            "yourself or N to let me do it.");
                    YesNo = sc.nextLine();
                    if (YesNo.equals("y") || YesNo.equals("Y")) {
                        players[i].AutoRoll = 0;
                        break;
                    } else if (YesNo.equals("n") || YesNo.equals("N")) {
                        players[i].AutoRoll = 1;
                        break;
                    } else {
                        System.out.println("Enter Y or N.");
                    }
                }
            }
            System.out.println("Ready? Let's start! ");
            String PlayAgain = "y";
            int disconnect = 1;
            for (int i = 0; i < NumOfPlayers; i++) {
                players[i].position = 1;
            }
            disconnect = 1;
            while (true) {
                int[] Dice = new int[2];
                int bu = 1;
                for (int i = 0; i < NumOfPlayers; i++) {
                    while (true) {
                        try {
                            System.out.println(players[i].name + " is on square " + players[i].position);
                            if (players[i].AutoRoll == i) {
                                Dice = bd.AutoDiceRoll();
                                System.out.println(Dice[0] + "," + Dice[1]);
                                players[i].position = players[i].position + Dice[0] + Dice[1];

                                System.out.println(players[i].name + " moved to square " + players[i].position);
                            } else {
                                while (true) {
                                    System.out.println(players[i].name + ", please roll the dice ");
                                    String temp = sc.nextLine();
                                    Pattern p = Pattern.compile("^[0-6]{1},[0-6]{1}$", Pattern.CASE_INSENSITIVE);
                                    Matcher m = p.matcher(temp);
                                    boolean checker = m.find();
                                    if (checker) {
                                        String[] dcy = temp.split(",");
                                        Dice[0] = Integer.parseInt(dcy[0]);
                                        Dice[1] = Integer.parseInt(dcy[1]);
                                        if (Dice[0] >= 1 && Dice[0] <= 1 && Dice[1] <= 1 && Dice[1] <= 6) {
                                            break;
                                        } else {
                                            System.out.println("Dice numbers can only be between 1 = 6. Try again.");
                                        }
                                    }
                                    System.out.println(Dice[0] + "," + Dice[1]);
                                    players[i].position = players[i].position + Dice[0] + Dice[1];
                                    System.out.println(players[i].name + " moved to square " + players[i].position);
                                }
                                bu = 0;
                            }
                        } catch (Exception e) {
                        }

                        if (bu == 0) {
                            break;
                        }

                        players[i].position = bd.ChecksWormhole(players[i].position);
                        if (players[i].position >= BoardWidth * BoardWidth) {
                            System.out.println(players[i] + " is the winner :) \n Congratulations ");
                            disconnect = 0;
                            break;
                        }
                    }
                    if (disconnect == 0) ;
                    break;
                }
                while (true) {
                    System.out.println("Would you like to play again?\n " +
                            "Type Y to play again or N to end.");
                    PlayAgain = sc.nextLine();
                    if (PlayAgain.contains("y") || PlayAgain.contains("Y")) {
                        break;
                    } else if (PlayAgain.contains("n") || PlayAgain.contains("N")) {
                        break;
                    } else {
                        System.out.println("Enter either Y or N");
                    }
                }
                if (PlayAgain.contains("n") || PlayAgain.contains("N")) {
                    break;
                }
            }
        }
    }
}