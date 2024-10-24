import java.util.Scanner;
 
class InvalidUserException extends Exception {
     
    public String getMessage() {
        return "Invalid card details. Try again!";
    }
}

 
class ATM {
    int acc_num = 1234;
    int password = 9999;
    int an, pwd;

    
    void acceptInput() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the account number:");
        an = s.nextInt();
        System.out.println("Enter the password:");
        pwd = s.nextInt();
    }

    
    void verify() throws InvalidUserException {
        if (acc_num == an && password == pwd) {
            System.out.println("Collect your money.");
        } else {
            throw new InvalidUserException();
        }
    }
}

 
class Bank {
    void initiate() {
        ATM atm = new ATM();
        int attempts = 0;

        while (attempts < 3) {
            try {
                atm.acceptInput();
                atm.verify();
                return; // Exit after successful verification
            } catch (InvalidUserException e) {
                System.out.println(e.getMessage());
                attempts++;
            }
        }
        System.out.println("Card Blocked. Please contact the bank.");
        System.exit(0);
    }
}

 
public class CustomException {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.initiate();
    }
}

