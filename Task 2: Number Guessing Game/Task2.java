import java.util.Random;
import java.util.Scanner;
import javax.swing.*;


//Name: Varun Gaur | Date Created: June 14th, 2024
public class Task2 {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to the Guessing Game!", "Guessing Game", 3);

        int flag = 1;

        while(flag == 1) {
            Random rand = new Random();
            Scanner scanner = new Scanner(System.in);
            int randomNumber = rand.nextInt(100) +1;
    
            String inpt =  JOptionPane.showInputDialog(null, "Enter Your Guess (1-100)");
            int attempts = 7;
            while (attempts > 1) {
                int guess = Integer.parseInt(inpt);
    
                if (guess == randomNumber) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You Won the Game!");
                    break;
                }
                else if (guess >randomNumber) {
                    attempts--;
                    inpt = JOptionPane.showInputDialog(null, "Random Number is Lower than the Input. TRY AGAIN!. Attempts left: " + attempts);
                }
                else {
                    attempts--;
                    inpt = JOptionPane.showInputDialog(null, "Random Number is Higher than the Input. TRY AGAIN!. Attempts left: " + attempts);
                }
            }
            if(attempts == 1) {
                String flags = JOptionPane.showInputDialog(null, "YOU LOSE.... Wanna Try Again?. Type 1 to reset, else this game will be exited."
                 + "\nThe Answer was " + randomNumber);
                flag = Integer.parseInt(flags);
            }
            if (flag == 1) {
                continue;
            }
        }
        JOptionPane.showMessageDialog(null, "Thanks for playing");
        
    }
}


// import javax.swing.*;
 
// public class Task1 {
//     public static void main(String[] args) {
//         Random rand = new Random();
//         Scanner scanner = new Scanner(System.in);
//         int randomNumber = rand.nextInt(100) +1;
//         int userAnswer = 0;
//         int attempts = 7;

//         while (userAnswer != randomNumber)
//         {
//             String response = JOptionPane.showInputDialog(null,
//                 "Enter a guess between 1 and 100", "Guessing Game", 3);
//             userAnswer = Integer.parseInt(response);
//             JOptionPane.showMessageDialog(null, ""+ 
//                 determineGuess(userAnswer, randomNumber, attempts));
//             attempts--;
//         }  
//     }

//     public static String determineGuess(int userAnswer, int computerNumber, int count){
//         if (userAnswer == computerNumber ){
//             return "Correct!\nTotal Guesses: " + count;
//         }
//         else if (userAnswer > computerNumber) {
//             return "Your guess is too high, try again.\nAttempts Left: " + count;
//         }
//         else if (userAnswer < computerNumber) {
//             return "Your guess is too low, try again.\nTry Number: " + count;
//         }
//         else {
//             return "Your guess is incorrect\nTry Number: " + count;
//         }
//     }
// }