package hw3;

public class TicTacToe {

    private static final char PLAYER_1 = 'X';
    private static final char PLAYER_2 = 'O';

    public static void main(String[] args)
    {

        Board game = new Board();
        Player [] player = new Player[2];
        

        if(args.length == 0)
        {
            player[0] = new HumanPlayer(PLAYER_1,1);
            player[1] = new HumanPlayer(PLAYER_2,2);
        }
       else
           {
               if(args[0].compareTo("-c") == 0 )
               {
                   if(args.length < 2)
                   {
                       player[0] = new ComputerPlayer(PLAYER_1,game,PLAYER_2);
                       player[1] = new ComputerPlayer(PLAYER_2,game,PLAYER_1);
                   }

                   else if(args[1].compareTo("1") == 0)
                   {
                       player[0] = new ComputerPlayer(PLAYER_1,game,PLAYER_2);
                       player[1] = new HumanPlayer(PLAYER_2,2);
                   }
                   else if (args[1].compareTo("2") == 0)
                   {
                       player[0] = new HumanPlayer(PLAYER_1,1);
                       player[1] = new ComputerPlayer(PLAYER_2,game,PLAYER_1);
                   }
                   else
                   {
                       System.out.println("Usage: java TicTacToe [-c [1|2]]");
                       return;

                   }
               }

               else
               {
                   System.out.println("Usage: java TicTacToe [-c [1|2]]");
                   return;
               }

           }

       boolean over = false;
       while(!over)
       {
           for(int i = 0 ; i < 2; i++)
           {
               game.printBoard();
               if(player[i] instanceof HumanPlayer)
               System.out.printf("Player %d, please enter a move (1-9): ", i + 1);




               int move = player[i].move();
               if(player[i] instanceof ComputerPlayer)
                   System.out.printf("Player %d (computer) chooses position: %d\n\n", i + 1,move);



               while (!game.setMove(move,player[i].getSymbol()))
               {
                   System.out.printf("That's not a valid move! Player %d, please enter a move (1-9):  ", i+1);
                   move = player[i].move();

               }

              if(game.win(player[i].getSymbol()) == true)
              {
                  game.printBoard();
                  System.out.printf("Player %d is winner!!! \n\n", i+1); // player i+1 is winner!!!
                  over = true;
                  break;
              }

              if(game.isBoardFull() == true)
              {
                  game.printBoard();
                  System.out.println("Draw!!!");
                  over = true;
                  break;
              }

              //output game board
               //check if the game is over

           }

       }

    }


}
