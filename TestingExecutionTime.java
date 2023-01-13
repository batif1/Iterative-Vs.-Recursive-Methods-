import java.lang.*; //Import the Library that has the Nanotime method.
import java.util.Scanner; //Importing the scanner method.

public class TestingExecutionTime {


    public static void main(String[] args) {

        // SECTION I: Calling the header method.
        header(1);                                //Calling the header method and sending through "1" so that it can print relevant information out!

        int factorialNumber = 0;
        // SECTION II + III: Receiving  valid user input.
        //Creating a while loop that ensures that the user enters a number greater than zero. If they do not, it will continue to ask again and again until the conditions are met.
        Boolean numberRecieved = false;                    //Initiate the "numberReceived" Boolean as false since we do not have any number.
        while (numberRecieved == false) {
            System.out.println("Please enter an integer that you would like to know a factorial of");
            Scanner userInput = new Scanner(System.in);    //Ask the user for an integer input using the Scanner class's methods.
            factorialNumber = userInput.nextInt();
            if (factorialNumber > 0) {                      //This if statement is the "exit" for this loop. It is only activated if the condition of the integer being >1 is met.
                    numberRecieved = true;
            }
        }


        // SECTIONS IV + V: Noting down the time it takes to use the iterative method.

        for (int i = 0; i<2; i++){                               //Since we are calling the iterative method twice, we should create a for loop to prevent code duplication.
            long begin = System.nanoTime();                    //This is where the next method starts, so we need to note the time it began.
            long factorial = iterative(factorialNumber);
            System.out.println("Execution " + (i+1) + " using the iterative method: "); //To easily differentiate between the two instances of this code running.
            System.out.println("Time taken (Nano Seconds): "+(System.nanoTime() - begin) + " The factorial of " + factorialNumber + " is " + factorial);   //We subtract the time it began to when it ended to get how much time it took
        }

        //SECTION VI: Nothing down the time it takes to use the recursive method.
        System.out.println("Recursive method");
        long begin = System.nanoTime();
        long factorial = reccursive(factorialNumber);
        System.out.println("Time taken (Nano Seconds): "+(System.nanoTime() - begin) + " The factorial of " + factorialNumber + " is " + factorial);   //We subtract the time it began to when it ended to get how much time it took

        //SECTION VII: Calling the footer method.
        footer(1);

    }

    // This method calculates the factorial of the number sent through it through iteration, and then returns it.
    public static long iterative(int n) {
        int i = 1;
        long result = 1;
        while (n >= i) {
            result = result * i;
            i++;
        }
        return result;
    }


    // This method calculates the factorial of the number sent through it using recursion, and then returns it.
    public static int reccursive(int n) {
        if (n == 0) {
            return 1;     //I don't understand how this does not print "1".
        }
        int result = n * (reccursive(n - 1));
        return result;
    }


    // Creating a header method that takes in the lab number and outputs relevant information about this project.
    public static void header(int labNumber) {
        System.out.println("Lab excersize: " + labNumber);
        System.out.println("Prepared By: Bashshar Atif");
        System.out.println("Student Number: 251219057");
        System.out.println("The goal of this exercise to is to compare the time it takes to calculate a factorial in an iterative vs. recursive method");
        System.out.println("_____________________________________________________________________");

    }

    // Creating a footer method that tajes in the exerceise number and prints out the relevant information to indicating the end of this exercise.
    public static void footer(int exerciseNumber){
        System.out.println("_____________________________________________________________________");
        System.out.println("Completion of Lab Exercise " + exerciseNumber + " is successful!");
        System.out.println("Signing off - Bashshar Atif.");
    }

}
