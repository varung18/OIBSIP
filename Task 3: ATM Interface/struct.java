
import java.util.ArrayList;

public class struct {
    private String uid;
    private String upin;
    private String firstName;
    private String lastName;
    private double AccBalance;
    public ArrayList<String> transactions;

    public struct(String firstName, String lastName, String uid, String upin, double AccountBalance) {
        //structure of the account
        this.uid = uid;
        this.upin = upin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.AccBalance = AccountBalance;
        this.transactions = new ArrayList<>();
    }

    public boolean authenticate(String upin) {
        return this.upin.equals(upin);
    }

    public boolean withdraw(double amount) { //checks whether amount to receive is greater than savings or not
        if (amount > AccBalance) {
            return false;
        } else {
            AccBalance -= amount;
            String transaction = "Withdrawal: -$" + amount + " New balance: $" + AccBalance;
            transactions.add(transaction);
            return true;
        }
    }

    public void deposit(double amount) {
        AccBalance += amount;
        String transaction = "Deposit: +$" + amount + " New balance: $" + AccBalance;
        transactions.add(transaction);
    }

    public boolean transfer(double amount, struct recipient) {
        if (amount <= AccBalance) {
            AccBalance -= amount;
            recipient.deposit(amount);
            transactions.add("Transfer of $" + amount + " to user " + recipient.getuid());
            return true;
        } else {
            return false;
        }
    }

    public String getuid() {
        return uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getAccBalance() {
        return AccBalance;
    }

    public ArrayList<String> getTransactionHistory() {
        return transactions;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
