import java.util.ArrayList;
import java.util.Scanner;


public class Users {
    public ArrayList<struct> user;
    public struct loggedUser;
    Scanner scanner = new Scanner(System.in);

    public Users() {
        this.user = new ArrayList<>();
        this.loggedUser = null;
        // add some initial test users
        user.add(new struct("Varun", "Gaur", "vgr784", "12345678", 2500.0));
        user.add(new struct("Mark", "Ramirez", "mkr109", "12349876", 1800.0));
        user.add(new struct("Utsavi", "Tambe", "utt730", "1597530", 3600.0));
        user.add(new struct("Georgia", "Petit", "gpt852", "98765432", 2000.0));
    }

    

    public boolean authenticateUser(String userID, String userPIN) { /*  checks if given 
        parameters matches one among the objects*/
        for (struct usercount : user) {
            if (usercount.getuid().equals(userID) && usercount.authenticate(userPIN)) {
                loggedUser = usercount;
                return true;
            }
        }
        return false;
    }

    public struct getloggedUser() {
        return loggedUser;
    }

    public struct getUserByID(String userID) { // used in transferring money into another account
        for (struct usercount : user) {
            if (usercount.getuid().equals(userID)) {
                return usercount;
            }
        }
        return null;
    }
}
