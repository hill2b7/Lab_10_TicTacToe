import java.util.Scanner;

public class SafeInput
{
    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;

    }



    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return an int that is not a double or string value
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;
        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer: " + trash);
            }

        }
        while(!done);
        return retVal;
    }


    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param low range start
     * @param high range end
     * @return a range of a double value
     */
    public static double getRangedDouble(Scanner pipe,String prompt, double low , double high)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");
            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.print("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }

        } while (!done);
        return retVal;
    }


    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param low range start
     * @param high range end
     * @return an int that is within the range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retVal = 0;
        boolean done = false;
        String trash = "";
        do
        {
            System.out.print("\n"+ prompt + "[" + low + "-" + high + "]: ");
            if(pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.print("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an Integer: " + trash);
            }
        }
        while(!done);
        return retVal;
    }


    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a double that is valid or not a string
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }

        }
        while(!done);
        return retVal;

    }

    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a boolean response
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean retVal = true;
        String YN = "";
        boolean gotAVal = false;
        do
        {
            System.out.print("\n" + prompt + " Y/N ");
            YN = pipe.nextLine();
            if(YN.equalsIgnoreCase("Y"))
            {
                gotAVal = true;
                retVal = true;
            }
            else if (YN.equalsIgnoreCase("N"))
            {
                gotAVal = true;
                retVal = false;
            }
            else
            {
                System.out.println("You must enter Y or N : " + YN);
            }
        }while(!gotAVal);

        return retVal;
    }

    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param regEx pattern for the user
     * @return a String response that matches the pattern given
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String response = "";
        boolean gotAVal = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if(response.matches(regEx))
            {
                gotAVal = true;
            }
            else
            {
                System.out.println("\n" + response + " must match the pattern " + regEx);
                System.out.println("Try again");
            }
        }while(!gotAVal);

        return response;
    }

    /**
     * @param msg The message that will be echoed in the program
     * @return a String response that is not zero length
     */
    public static void prettyHeader(String msg)
    {

        final int CHAR_COUNT = 60;

        int totalSpaces = CHAR_COUNT - 6 - msg.length();
        int leftSpaces, rightSpaces;
        if (totalSpaces %2 == 0)
        {
            leftSpaces = rightSpaces = totalSpaces / 2;
        }
        else
        {
            rightSpaces = totalSpaces /2;
            leftSpaces = rightSpaces + 1;
        }
        for (int x = 0; x <= 2; x++)
        {
            System.out.print("*");
        }
        for (int x = 0; x<= leftSpaces; x++)
        {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int x = 0; x <= rightSpaces; x++)
        {
            System.out.print(" ");
        }
        for (int x = 58; x <= 60; x++)
        {
            System.out.print("*");
        }

    }




}





