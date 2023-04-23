import java.util.Random;
import java.util.Scanner;
class Game {
    int systemInput;
    int userInput;
    int noOfGuesses = 0;

    Game() {
        Random random = new Random();
        this.systemInput = random.nextInt(100) + 1;
    }

    public boolean takeUserInput() {
        if (noOfGuesses < 10) {
            System.out.print("Guess The Number : ");
            this.userInput = GuessTheNumber.takeIntegerInput(100);
            noOfGuesses++;
            return false;
        }
        else {
            System.out.print("number of attempts finished....better luck next time\n");
            return true;

        }

    }
    public boolean isCorrectGuess (){
        if(systemInput == userInput) {
            System.out.println("congratulations, you guess the number " + systemInput + " in " + noOfGuesses +"guesses");
            switch(noOfGuesses) {
                case 1:
                    System.out.println("your score is 100");
                    break;
                case 2:
                    System.out.println("your score is 90");
                    break;
                case 3:
                    System.out.println("your score is 80");
                    break;
                case 4:
                    System.out.println("your score is 70");
                    break;
                case 5:
                    System.out.println("your score is 60");

                case 6:
                    System.out.println("your score is 50");
                    break;
                case 7:
                    System.out.println("your score is 40");
                    break;
                case 8:
                    System.out.println("your score is 30");
                    break;
                case 9:
                    System.out.println("your score is 20");
                    break;
                case 10:
                    System.out.println("your score is 10");
                    break;
            }
            System.out.println();
            return true;
        }
        else if (noOfGuesses < 10 && userInput > systemInput) {
            if (userInput - systemInput > 10) {
                System.out.println("too high");
            }
            else {
                System.out.println("little high");
            }
        }
        else if (noOfGuesses < 10 && userInput < systemInput) {
            if (userInput - systemInput > 10) {
                System.out.println("too low");
            }
            else {
                System.out.println("little low");
            }
        }
        return false;
    }
}



public class GuessTheNumber {
    public static int takeIntegerInput(int limit) {
        int input =0;
        boolean flag = false ;

        while ( !flag ) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if ( flag && input > limit || input < 1) {
                    System.out.println("choose the number between 1 to " + limit);
                    flag = false;
                }
            }
            catch (Exception e) {
                System.out.println("enter only integer value");
                flag = false;
            }
        };
        return input;
    }

    public static void main(String[] args) {
      System.out.println("1.Start The Game \n 2.Exit");
      System.out.println("enter your choice :  ");
      int choice = takeIntegerInput(2);
      int nextRound = 1;
      int noOfRound = 0;

      if(choice  == 1) {
          while(nextRound == 1) {
              Game game = new Game();
              boolean isMatched = false;
              boolean isLimitCross= false;
              System.out.println("\nRound " +  ++noOfRound + " starts....");

              while (!isMatched && !isLimitCross) {
                  isLimitCross = game.takeUserInput();
                  isMatched = game.isCorrectGuess();
              }
              System.out.println("1. NextRound \n 2. Exit");
              System.out.println("Enter Your Choice : ");
              nextRound = takeIntegerInput(2);
              if (nextRound != 1) {
                  System.exit(0);
              }
          }
      }
      else {
          System.exit(0);
      }
    }
}