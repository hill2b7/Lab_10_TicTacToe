import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];


    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in); //setup of new scanner for input
        boolean done = false; //variable declaration
        boolean gameOver = false; //variable declaration
        int colMove = 0; //variable declaration
        int rowMove = 0; //variable declaration
        int moveCount = 0; //variable declaration
        String player = "X";//variable reset

        //start of the games control loop that will run until the done condition is met or "Do you want to play again" is answered as no
        do {
            System.out.println("Welcome to Tic Tac Toe"); //Welcoming the user
            clearBoard(); //calls for clear board method to set up the board for the beginning of the game
            showBoard(); //method that displays the board to the user
            moveCount = 0; //sets movecount to 0 for the start of each game

            //start of a loop that will run until a user has won or there is a tie determined
            do {
                gameOver = false; //resets the boolean to false so nothing is stored from the previous game

                //loop that will run until the input received is valid
                do {
                    rowMove = SafeInput.getRangedInt(in, "Player " + player + " Enter the row ", 1, 3); //collecting the users move coordinate for row
                    colMove = SafeInput.getRangedInt(in, "Player " + player + " Enter the col ", 1, 3); //collecting the users move coordinate for column
                    rowMove = rowMove - 1; //subtract 1 in order to match the input to array indices
                    colMove = colMove - 1; //subtract 1 in order to match the input to array indices
                }
                while (!isValidMove(rowMove, colMove)); //when the condition is met the loop will break

                board[rowMove][colMove] = player; //sets the board the store the String player's value
                moveCount++; //increment of moveCount
                showBoard(); //displays board to user with updated moves

                if (moveCount >= 5) //if statement that will execute once movecount is greater than or equal to 5
                {
                    if (isWin(player)) //if statement that will execute if there is a win determined by the method isWin()
                    {
                        System.out.println("The winner is " + player); //output that tells the user who won
                        gameOver = true; //boolean that gets set to true and breaks the loop ending the game
                    }
                    if (moveCount >= 7) //if statement that will execute once movecount is greater than or equal to 7
                    {
                        if (isTie()) //if statement that will determine if the game ends in a tie
                        {
                            System.out.println("The game ends in a tie"); //output that lets the user know the game ended in a tie
                            gameOver = true; //boolean that gets set to true and breaks the loop ending the game
                        }
                    }
                }


                if (player == "X") //if statement that will execute if the player is equal to X
                {
                    player = "O"; // if the player is equal to X then it switches to O
                }
                else if (player == "O") //if statement that will execute if the player is equal to O
                {
                    player = "X"; // if the player is equal to O then it switches to X
                }


            } while (!gameOver); //loop will run until the condition is met, once met the loop breaks

            done = SafeInput.getYNConfirm(in, "Do you want to play again?"); //Prompt from SafeInput that asks the user if they want to play again

        } while (done); //if the condition is met the loop breaks

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
        return false; //no column win
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
        boolean retVal = true;
        for(int row = 0; row < ROW; row++)
        {
            for (int col = 0; col < COL; col++)
            {
                if (board[row][col].equals("-"))
                {
                    retVal = false;
                }
            }
        }

        return retVal;
    }




}