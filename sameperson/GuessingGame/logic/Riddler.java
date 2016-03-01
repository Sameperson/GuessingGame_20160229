package com.sameperson.GuessingGame.logic;

import java.util.Random;
import java.util.Scanner;

public class Riddler {

    private int riddledNumber;
    private int guess;
    private int maxRiddledNumber;

    private Scanner reader;
    private Random random;

    public Riddler(int number) {
        this.random = new Random();
        this.riddledNumber = random.nextInt(number + 1);
        this.maxRiddledNumber = number;
        this.reader = new Scanner(System.in);
    }

    public void run() {
        String input;
        while(true) {
            System.out.println("Enter your number between 1 and " + maxRiddledNumber +": ");
            input = reader.nextLine();
            if(input.equals("q")) {
                System.out.println("The game has been interrupted. Bye!");
                break;
            }
            try {
                guess = Integer.parseInt(input);
            }
            catch (NumberFormatException e) {
                System.out.println("Not a number!");
                continue;
            }
            if(validateGuess(guess) < 0) {
                break;
            }
        }
    }

    private int validateGuess(int guess) {
        if(guess == this.riddledNumber) {
            System.out.println("Right guess!");
            return -1;
        } else if(guess > this.riddledNumber) {
            System.out.println("Riddled number is lower");
            return 1;
        } else if(guess < this.riddledNumber) {
            System.out.println("Riddled number is higher");
            return 1;
        }
        System.out.println("Unable to process a guess, try again!");
        return 1;
    }
}