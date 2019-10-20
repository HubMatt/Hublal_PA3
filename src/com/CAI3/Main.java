package com.CAI3;
import java.util.Scanner;
import java.security.SecureRandom;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int i,levelMultiplier,endSes = 0;
        double studentAnswer,Answer,threshold = 0.00000000001;
        Scanner scnr = new Scanner(System.in);
        do {
            int correct = 0;
            System.out.printf("Please enter a difficulty level of 1 - 4, 1 being the lowest level and 4 being the highest level of difficulty.\n");
            int difficultLevel = scnr.nextInt();
            System.out.printf("Please enter the type of arithmetic problems you wish to solve\n1 being addition \n2 being multiplication \n3 being subtraction \n4 being division and \n5 being a random mixture of all of these\n");
            int arithmetic = scnr.nextInt();
            switch (difficultLevel) {
                case (1):
                    levelMultiplier = 1;
                    break;
                case (2):
                    levelMultiplier = 10;
                    break;
                case (3):
                    levelMultiplier = 100;
                    break;
                case (4):
                    levelMultiplier = 1000;
                    break;
                default:
                    System.out.printf("Error. The difficultly level only goes from 1 to 4.\n");
                    return;
            }
            for (i = 0; i < 10; i++) {
                SecureRandom secureRandomGenerator = new SecureRandom();
                int randInt1 = secureRandomGenerator.nextInt(9 * levelMultiplier)+1*levelMultiplier;
                int randInt2 = secureRandomGenerator.nextInt(9 * levelMultiplier)+1*levelMultiplier;
                Random rand = new Random();
                switch (arithmetic) {
                    case (5):
                        arithmetic = (rand.nextInt(4) + 1);
                    case (1):
                        System.out.printf("How much is %d plus %d?\n", randInt1, randInt2);
                        Answer = (randInt1 + randInt2);
                        break;
                    case (2):
                        System.out.printf("How much is %d times %d?\n", randInt1, randInt2);
                        Answer = (randInt1 * randInt2);
                        break;
                    case (3):
                        System.out.printf("How much is %d minus %d?\n", randInt1, randInt2);
                        Answer = (randInt1 - randInt2);
                        break;
                    case (4):
                        System.out.printf("How much is %d divided by %d?\n", randInt1, randInt2);
                        Answer = ((float)randInt1 / randInt2);
                        break;

                    default :
                        return;
                }
                studentAnswer = scnr.nextDouble();
                int randResponse = rand.nextInt(4) + 1;
                if ((Math.abs(Answer - studentAnswer) < threshold)) {
                    correct++;
                    switch (randResponse) {
                        case (1):
                            System.out.printf("Very Good!\n");
                            break;
                        case (2):
                            System.out.printf("Excellent!\n");
                            break;
                        case (3):
                            System.out.printf("Nice work!\n");
                            break;
                        case (4):
                            System.out.printf("Keep up the good work!\n");
                            break;
                    }
                } else
                    switch (randResponse) {
                        case (1):
                            System.out.printf("No. Please try again.\n");
                            break;
                        case (2):
                            System.out.printf("Wrong. Try once more.\n");
                            break;
                        case (3):
                            System.out.printf("Don't give up!\n");
                            break;
                        case (4):
                            System.out.printf("No. Keep trying.\n");
                            break;
                    }
            }
            if (correct > 7)
                System.out.printf("You got %.1f percent correct.\nCongratulations, you are ready to go to the next level.\n",((float)correct*10));
            else if (correct <= 7)
                System.out.printf("You got %.1f percent correct.\nPlease ask your teacher for extra help.\n",((float)correct*10));
            System.out.printf("Would you like to try again? Type 0 for yes and 1 for no\n");
            endSes = scnr.nextInt();
        } while(endSes == 0);
    }
}
