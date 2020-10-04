package hw3;

public class Board {
    private final int rows = 3, columns = 3;
    private char [][] board = new char[rows][columns];

    public Board()
    {
        initialize();
    }

    public char[][] getBoard() {
        return board;
    }

    public void printBoard()
    {
        System.out.println("Game Board: \t\t\tPositions:\n");
        int counter = 1;
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                System.out.print(board[i][j]);
                if(j != columns - 1)
                System.out.print(" | ");


            }
            System.out.print("\t\t\t");
            for(int k = 0; k < columns ; k++)
            {
                System.out.print(counter);
                if(k != columns - 1)
                System.out.print(" | ");
                counter++;
            }

            if(i != rows-1)
            {
                System.out.println("\n---------- \t\t\t----------");
            }
        }




        System.out.println('\n');

    }
    public boolean isBoardFull()
    {

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
    public boolean win(char symbol)
    {
        if(rowWin(symbol) == true)
            return true;
        else if (diagonalWin(symbol) == true)
            return true;
        else if(columnWin(symbol) == true)
            return true;
        else
            return false;
    }
    private boolean rowWin(char s)
    {
        if((board[0][0] == s) && (board[0][1] == s) && board[0][2] == s)
            return true;

            // middle row
        else if((board[1][0] == s) && (board[1][1] == s) && (board[1][2] == s))
            return true;

            // bottom row
        else if((board[2][0] == s) && (board[2][1] == s) && (board[2][2] == s))
            return true;
        else
            return false;
    }
    private boolean columnWin(char s)
    {
        if((board[0][0] == s) && (board[1][0] == s) && (board[2][0] == s))
            return true;

            // middle column
        else if((board[0][1] == s) && (board[1][1] == s) && (board[2][1] == s))
            return true;

            // right column
        else if((board[0][2] == s) && (board[1][2] == s) && (board[2][2] == s))
            return true;

        else
            return false;


    }
    private boolean diagonalWin(char s)
    {
        if((board[0][0] == s) && (board[1][1] == s) && (board[2][2] == s))
            return true;

            // the other diagonal
        else if((board[0][2] == s) && (board[1][1] == s) && (board[2][0] == s))
            return true;
        else
            return false;

    }
    private void initialize()
    {
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                board[i][j] = ' ';
            }
        }
    }

    public boolean setMove(int move, char symbol)
    {
        int counter = 1;
        if(move < 1 || move > 9)
            return false;
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {


                if(counter == move)
                {
                    if(board[i][j] != ' ')
                        return false;

                    else
                    {
                        board[i][j] = symbol;
                        return true;

                    }


                }

                counter++;
            }

        }
        return false;

    }
    public boolean isMiddleAvailable()
    {
        if(board[1][1] == ' ')
            return true;

        return false;
    }
    public boolean isSpaceAvailable(int index)
    {
        int counter = 1;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(counter == index)
                {
                    if(board[i][j] != ' ')
                        return false;

                    else
                        return true;

                }
                counter++;
            }
        }
        return false;

    }
    public int winningMove(char s)
    {
        int counter = 1;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(board[i][j] == ' ')
                {
                    board[i][j] = s;


                    if (win(s))
                    {
                        board[i][j] = ' ';
                        return counter;
                    }
                    board[i][j] = ' ';

                }

                    counter++;
            }
        }
        return -1;
    }


}
