// Sujan Poudel
// Period 1 ADSA
// 11/10/22
// Lab 09: Greedy+
// Purpose: To utilize math, Random, and input classes combined with
// loops (for and while) to create five separate programs
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

public class Main {
    static Random randomGenerator = new Random();
    static Scanner scannerObj = new Scanner(System.in);

    public static void main(String[] args) {    
        //method calls follow. Un-comment any line to make that method run.        
        // rollDice();
        // guessMyNumberLimitedWithWhile();
        // guessMyNumberLimitedWithFor();
        // guessMyNumberUnlimited();
        // greedy();
       
    }//end of main method
   
    //rollDice()
    public static void rollDice() {
        int randomNumber1, randomNumber2;
        randomNumber1 = (int) (1 + 6 * Math.random());
        randomNumber2 = (int) (1 + 6 * Math.random());
       
        String[] dieCodes = {
                "\n\tx\n",
                "x\n\n\t\tx",
                "x\n\tx\n\t\tx",
                "x\t\tx\n\nx\t\tx",
                "x\t\tx\n\tx\nx\t\tx",
                "x\t\tx\nx\t\tx\nx\t\tx"
        };
       
        System.out.println("You rolled " + randomNumber1 + ", " + randomNumber2 + ":");
        System.out.println("-------------------");
        System.out.println(dieCodes[randomNumber1 - 1]);
        System.out.println("-------------------");
        System.out.println(dieCodes[randomNumber2 - 1]);
        System.out.println("-------------------");
    }
   
    //guessMyNumberLimitedWithWhile()
    public static void guessMyNumberLimitedWithWhile(){
        int correctNumber = randomGenerator.nextInt(1000) + 1;
        int guesses = 10;
       
        System.out.println("What number am I thinking about? You have 10 guesses.");
        while (guesses > 0) {
            System.out.print("Guess " + (11 - guesses) + ": ");
            int inputInt = scannerObj.nextInt();
            if (inputInt > correctNumber)
                System.out.println("Guess lower");
            else if (inputInt < correctNumber)
                System.out.println("Guess higher");
            else {
                System.out.println("Congratulations! You got it. The number was " + correctNumber + ".");
                return;
            }
           
            guesses--;
        }
        System.out.println("Sorry, you have no guesses left. The number was " + correctNumber + ".");
    }
   
    //guessMyNumberLimitedWithFor()
    public static void guessMyNumberLimitedWithFor(){
        int correctNumber = (int) (1 + 1001 * Math.random());
        int guesses;
       
        System.out.println("What number am I thinking about? You have 10 guesses.");
        for (guesses = 10; guesses > 0; guesses--) {
            System.out.print("Guess " + (11 - guesses) + ": ");
            int inputInt = scannerObj.nextInt();
            if (inputInt > correctNumber)
                System.out.println("Guess lower");
            else if (inputInt < correctNumber)
                System.out.println("Guess higher");
            else {
                System.out.println("Congratulations!  You got it.  The number was " + correctNumber);
                return;
            }
           
        }
        System.out.println("Sorry, you have no guesses left.  The number was " + correctNumber);    
   
    }
   
    //guessMyNumberUnlimited()
    public static void guessMyNumberUnlimited(){
        int correctNumber = randomGenerator.nextInt(1000) + 1;
        int GUESS = 1;
       
        System.out.println("What number am I thinking about? You have infinite guesses.");
        while (GUESS > 0) {
            System.out.print("Guess " + GUESS + ": ");
            int inputInt = scannerObj.nextInt();
            if (inputInt > correctNumber)
                System.out.println("Guess lower");
            else if (inputInt < correctNumber)
                System.out.println("Guess higher");
            else {
                System.out.println("Congratulations! You got it. The number was " + correctNumber);
                return;
            }  
            GUESS++;
        }
    }
   
    //greedy()
    public static void greedy() {
        //prompt the user for a monetary input
        Scanner sc = new Scanner(System.in);
        double changeToGive = 0;
       
        do {
            //if the user gave us a negative dollar amount
            //TODO: write why we need to have this if-statement here, if we have the same condition for our do-while below?
            // The if-statement has a slightly different condition than the do-while, it checks for only negative inputs.
            // This is needed because a negative input is invalid whereas 0 is simply no change at all.
            if(changeToGive < 0)
                System.out.println("Dollar amounts must be positive.");
           
            //if the current amount is zero dollars
            else if(changeToGive == 0)
                System.out.println("How much change do you need to pay out?");
           
            // while the user's input is not a valid double, prompt again
            while (!sc.hasNextDouble()) {
                System.out.println("Invalid input. How much change do you need to pay out?");
                sc.next(); // TODO: answer what this line is doing.
                // This line makes sure the scanner reads the next input typed if the current input is invalid. If this line is not here, the while loop will forever print that it's an invalid input.
            }
           
            //if the user entered a valid double, assign it to changeToGive
            changeToGive = sc.nextDouble();
           
        } while (changeToGive <= 0); //if user entered a negative double do it all again
        int numQuarters = 0;
        int numNickels = 0;
        int numDimes = 0;
        int numPennies = 0;
        // TODO: write some code here to solve the problem
        while (changeToGive > 0) {
        if (changeToGive - 0.25 >= 0) {
            numQuarters += 1;
            changeToGive -= 0.25;
        } else if (changeToGive - 0.1 >= 0) {
            numDimes += 1;
            changeToGive -= 0.1;
        } else if (changeToGive - 0.05 >= 0) {
            numNickels += 1;
            changeToGive -= 0.05;
        } else if (changeToGive - 0.01 >= 0) {
            numPennies += 1;
            changeToGive -= 0.01;
        }
        changeToGive = Math.floor(changeToGive * 100 + 0.5)/100;    
        }
        // make sure to print your final answer! (ex: 1 quarter, 2 pennies, 4 nickels).
        String quarterDenom = numQuarters == 1 ? "quarter" : "quarters";
        String dimeDenom = numDimes == 1 ? "dime" : "dimes";
        String nickelDenom = numNickels == 1 ? "nickel" : "nickels";
        String pennyDenom = numPennies == 1 ? "penny" : "pennies";
        System.out.println("Your change is " + numQuarters + " " + quarterDenom + ", " + numDimes + " " + dimeDenom + ", " + numNickels + " " + nickelDenom + ", and " + numPennies + " " + pennyDenom + ".");
    }
}
