import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int ROCK = 1;
        final int PAPER = 2;
        final int SCISSORS = 3;
        char option = 'n';


        Scanner scan = new Scanner(System.in); //System.in  java refers to the keyboard

        do {
            int ties = 0;
            int userWins = 0;
            int computerWins = 0;

            System.out.println("Let's Play the game");
            System.out.println("****************************************");
            System.out.println("How many rounds would you like to play?");
            int rounds = scan.nextInt();

            if (rounds < 1 || rounds > 10) {
                System.out.println("Invalid input");
                System.exit(-1);
            }

            for (int i = 0; i < rounds; i++) {
                int tiesRound = 0;
                int computerWinRound = 0;
                int userWinRound = 0;

                // get user input for user choice
                int userChoice = getUserChoice();
                // get computer's choice
                int computerChoice = getComputerChoice();
                // find who won the round
                if (userChoice == computerChoice) {
                    ties++;
                    System.out.println("It's a draw");
                } else {
                    switch (userChoice) {
                        case 1:
                            if (computerChoice == 2) {
                                computerWinRound++;
                                computerWins++;
                            } else if (computerChoice == 3) {
                                userWins++;
                            }
                            break;
                        case 2:
                            if (computerChoice == 1) {
                                userWinRound++;
                                userWins++;
                            } else if (computerChoice == 3) {
                                computerWinRound++;
                                computerWins++;
                            }
                            break;
                        case 3:
                            if (computerChoice == 1) {
                                computerWins++;
                            } else if (computerChoice == 2) {
                                userWinRound++;
                                userWins++;
                            }
                            break;
                        default:
                            System.out.println("Invalid user choice");
                            break;
                    }
                }

                // print the result of the round
                System.out.println("Results of round : " + (i + 1));
                System.out.println("You choose " + userChoice);
                System.out.println("Computer choose " + computerChoice);

                if (tiesRound == 1) {
                    System.out.println("It's a tie...");
                } else if (computerWinRound == 1) {
                    System.out.println("Computer wins the round");
                } else if (userWinRound == 1) {
                    System.out.println("User wins the round");
                }
                //System.out.println("Number of ties : " + tiesRound);
            }

            System.out.println("****************************************");
            System.out.println("End of this game!");
            System.out.println("Final results");
            System.out.println("Total number of ties: " + ties);
            System.out.println("Total number of user wins: " + userWins);
            System.out.println("Total number of computer wins: " + computerWins);
            System.out.println("****************************************");

            if (userWins > computerWins) {
                System.out.println("You are the WINNER!");
            } else if (userWins < computerWins) {
                System.out.println("Computer is the WINNER !");
            } else if (computerWins == userWins) {
                System.out.println("No Winner");
            }

            System.out.println("Do you want to continue? (y/n):");
            option = scan.next().charAt(0);
        } while (option == 'y');


        System.out.println("Goodbye !");
    }
        private static int getComputerChoice() {

            return ((int) (Math.random() * 3) + 1);
        }


    private static int getUserChoice() {
        Scanner scan = new Scanner(System.in);
        System.out.println("****************************************");
        System.out.println("1 =  Rock");
        System.out.println("2 =  Paper");
        System.out.println("3 =  Scissors");
        System.out.println("Please enter your choice");
        System.out.println("****************************************");
        int userChoiceInMethod =  scan.nextInt();
        return userChoiceInMethod;
    }
}