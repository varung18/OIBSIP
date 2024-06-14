import java.util.Scanner;

public class Process {
    
    public Users record;
    public Scanner scanner;

    public Process() {
        this.record = new Users();
        this.scanner = new Scanner(System.in);
    }
    public boolean login() { //login phase
        System.out.print("Enter the User ID: ");
        String uid = scanner.nextLine();
        System.out.print("Enter the User PIN: ");
        String upin = scanner.nextLine();
        return record.authenticateUser(uid, upin);
    }

    //  Transaction History  
    public void showTransactions() {
        struct loggedUser = record.getloggedUser();
        System.out.println("Provided Transaction history for " + loggedUser.getFullName() + ":");
        for (String transaction : loggedUser.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }


    //  Withdraw  
    public void doWithdraw() {
        struct loggedUser = record.getloggedUser();
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (loggedUser.withdraw(amount)) {
            System.out.println("Withdrawal successful, new balance: $" + loggedUser.getAccBalance());
        } else {
            System.out.println("Insufficient funds. Lower the amount to make withdrawal successful.");
        }
    }


    //  Deposit
    public void doDeposit() {
        struct loggedUser = record.getloggedUser();
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        loggedUser.deposit(amount);
        System.out.println("Deposit successful, new balance: $" + loggedUser.getAccBalance());
    }


    //  Transfer  
    public void doTransfer() {
        struct loggedUser = record.getloggedUser();

        System.out.print("Enter the recipient User ID: ");
        String recipientID = scanner.nextLine();
        struct recipient = record.getUserByID(recipientID);
        if (recipient == null) {
            System.out.println("Recipient not found.");
            return;
        }


        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        if (loggedUser.transfer(amount, recipient)) {
            System.out.println("Transfer successful, new balance: $" + loggedUser.getAccBalance());
        } else {
            System.out.println("Insufficient funds. Lower the amount to make withdrawal successful.");
        }

    }


}
