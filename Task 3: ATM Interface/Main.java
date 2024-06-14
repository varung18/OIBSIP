import java.util.Scanner;

// Name: Varun Gaur | Date Created: June 14th, 2024
public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the ATM");

            Process pro = new Process();
            while (true) {
                if (pro.login()) {
                    while (true) {

                        System.out.println("Choose a valid option as per the following:");
                        System.out.println("1. View transaction history");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Deposit");
                        System.out.println("4. Transfer");
                        System.out.println("5. Quit");
                        System.out.print("Choice: ");

                        int choice = scanner.nextInt();

                        switch (choice) {
                            case 1:
                                pro.showTransactions(); //display the transactions done so far
                                break;
                            case 2:
                                pro.doWithdraw(); // adds money into the bank account
                                break;
                            case 3:
                                pro.doDeposit(); // deducts money into the bank account
                                break;
                            case 4:
                                pro.doTransfer(); // transfers money into another account
                                break;
                            case 5:
                                System.out.println("Thank you. Visit Again");
                                return;
                            default:
                                System.out.println("Incorrect choice, please try again");
                                break;
                        }
                    } //end of loop
                }
                else {
                    System.out.println("Incorrect user ID or PIN, please try again");
                }

            }
        } catch (Exception e){
            System.out.println(e);
        } 
    } // end of main
} //end of class