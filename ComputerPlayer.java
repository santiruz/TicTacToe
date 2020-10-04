package hw3;

import com.sun.source.tree.BreakTree;

import java.util.Random;
import java.util.Scanner;
import java.lang.Math;


public class ComputerPlayer extends Player
{
    private char symbol, opponentSymbol;
    private Board board;

    @Override
    public int move()
    {
        int win = board.winningMove(symbol);

        if (win != -1)
            return win; //rule 1

        int opponentWin = board.winningMove(opponentSymbol);
        if (opponentWin != -1)             //rule 2
        {
            return opponentWin;

        }
        if (board.isMiddleAvailable()) {
            return 5;
        }

        Random r1 = new Random();
        int number;
        do {
            number = r1.nextInt(9) + 1;

        } while (!board.isSpaceAvailable(number));

        return number;


    }


    public ComputerPlayer(char s, Board board, char opp)
    {

        this.symbol = s;
        this.board = board;
        this.opponentSymbol = opp;
    }

    @Override
    public char getSymbol()
    {
        return symbol;
    }


}
