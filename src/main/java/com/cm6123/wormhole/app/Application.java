package com.cm6123.wormhole.app;

import com.cm6123.wormhole.app.userinputs.NumInput;
import com.cm6123.wormhole.app.userinputs.WordInput;
import com.cm6123.wormhole.app.userinputs.YesNo;
import com.cm6123.wormhole.dice.Dice;
import com.cm6123.wormhole.player.Player;
import com.cm6123.wormhole.board.Board;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Application {
    private Logger logger = LoggerFactory.getLogger(Application.class);
    private WordInput wordInput = new WordInput();
    private NumInput numInput = new NumInput();
    private YesNo yesNo = new YesNo();
    private Board gboard;
}