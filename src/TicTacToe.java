import java.util.Scanner;

public class TicTacToe
{
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean done = false;
        boolean isTie = false;
        int colMove = 0;
        int rowMove = 0;
        int moveCount = 0;
        String player = "X";



        do {
            System.out.println("Welcome to Tic Tac Toe");
            clearBoard();
            showBoard();
            moveCount = 0;


            do
            {
                do
                {
                    rowMove = SafeInput.getRangedInt(in, "Player " + player + " Enter the row ", 1, 3);
                    colMove = SafeInput.getRangedInt(in, "Player " + player +" Enter the col ", 1, 3);
                    rowMove = rowMove - 1;
                    colMove = colMove - 1;
                }
                while (!isValidMove(rowMove, colMove));

                board[rowMove][colMove] = player;
                moveCount++;
                showBoard();

                if (moveCount >= 5)
                {
                    if (isWin(player))
                    {
                        System.out.print("Player " + player + " has won\n");
                        break;
                    }
                    else if(moveCount == 9)
                    {
                        System.out.println("Game has ended in a tie ");
                        isTie = true;
                    }
                }

                if (player == "X")
                {
                    player = "O";
                }
                else if (player == "O")
                {
                    player = "X";
                }

            } while (!isWin(player) || !isTie);



            if (player == "X")
            {
                player = "O";
            }
            else if (player == "O")
            {
                player = "X";
            }
            done = SafeInput.getYNConfirm(in, "Do you want to play again?");

            }while (done);

        }









    private static void clearBoard()
    {
        for (int row = 0; row < ROW; row++)
        {
            for (int col = 0; col < COL; col++)
            {
                board[row][col] = "-";
            }
            System.out.println(" ");

        }
    }
    private static void showBoard()
    {

        for (int row= 0;  row < ROW; row++)
        {
            System.out.print("| ");
            for (int col = 0;  col < COL; col++)
            {
                System.out.print( board[row][col] + " | ");
            }
            System.out.println("");
        }


    }
    private static boolean isValidMove (int row, int col)
    {
        boolean move = false;

            if (board[row][col].equals("-"))
            {
                move = true;
            }
            else
            {
                System.out.println("\n There is already a player move there! Try again");

            }
            return move;
    }

    private static boolean isWin(String player)
    {
        if (isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            return true;
        }
        return false;
    }
    private static boolean isRowWin(String player)
    {
        for(int row = 0; row < ROW; row++)
        {
            if(board[row][0].equals(player)&&board[row][1].equals(player)&&board[row][2].equals((player)))
            {
                return true;
            }
        }
        return false; // no row win
    }
    private static boolean isColWin(String player)
    {
        for(int col = 0; col < COL; col++)
        {
            if(board[0][col].equals(player)&&board[1][col].equals(player)&&board[2][col].equals((player)))
            {
                return true;
            }
        }
        return false; // no col win
    }
    private static boolean isDiagonalWin(String player)
    {
        for(int col = 0; col < COL; col++)
        {
            if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
                return true;
            } else if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
                return true;
            }
        } return false;

    }
    private static boolean isTie()
    {
        for(int row = 0; row < ROW; row++)
        {
            for (int col = 0; col < COL; col++)
            {
                if (board[row][col] == "-");
                {
                    return false;
                }
            }

        }

        return true;
    }




}