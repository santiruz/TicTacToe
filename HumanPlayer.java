package hw3;

import java.util.Scanner;

public class HumanPlayer extends Player {

   private char symbol;
   private int playerNum;

    public HumanPlayer(char s,int p)
    {

        this.symbol = s;
        this.playerNum = p;
    }

    @Override
    public char getSymbol()
    {
        return this.symbol;
    }


    @Override
    public int move()
    {

        Scanner input = new Scanner(System.in);
        int move = 0;

        if(input.hasNextInt())
        {
            move = input.nextInt();

        }
        else
        {
            System.out.print("That's not a valid move! ");
            if(this.getSymbol() == 'X')
                System.out.print("Player 1, please enter a move (1-9): ");
            else
                System.out.print("Player 2, please enter a move (1-9): ");
            move();
        }
        System.out.println();
        return move;


    }





}
