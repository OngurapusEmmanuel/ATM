import java.util.Scanner;

public class jav {
    static long AccountBalance = 10000;
    static String AccountName = "Emmanuel";
    static String AccountPassword = "Emm1234";

    public static void login() {
        String accountName;
        String password;

        Scanner input = new Scanner(System.in);
        System.out.println("Sign in");

        System.out.print("Enter your username:");
        accountName = input.nextLine();

        System.out.println();

        System.out.print("Enter your password:");
        password = input.nextLine();
        System.out.println();

        System.out.println("Your account name is:" + accountName);
        System.out.println("Your account secret pin is:" + password);

        if (accountName.equals(AccountName) && password.equals(AccountPassword)) {
            menu();
        } else {
            System.out.println("Credentials don't match\nLogin not successful");
            login(); // Retry login
        }
    }

    public static void menu() {
        System.out.println("\t\t\t********MENU********");
        System.out.println("\tWelcome to the online transaction platform.");
        System.out.println("\t\t1. Withdraw");
        System.out.println("\t\t2. Deposit");
        System.out.println("\t\t3. Check balance");
        System.out.println("\t\t4. Transfer cash");
        System.out.println("\t\t5. Exit");

        choice();
    }

    public static void choice() {
        int ch = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("please select a transaction:");
        ch = input.nextInt();
        System.out.println();

        switch (ch) {
            case 1:
                withdraw();
                break;
            case 2:
                deposit();
                break;
            case 3:
                checkBal();
                break;
            case 4:
                transfer();
                break;
            case 5:
                Exit();
                break;
            default:
                System.out.println("please enter a valid choice!");
                choice();
                break;
        }
    }

    public static void withdraw() {
        Scanner input = new Scanner(System.in);
        System.out.println("Available balance is:" + AccountBalance);
        System.out.print("Enter amount you want to withdraw:");
        long withdrawAmount = input.nextLong();
        System.out.println();
        System.out.println("You withdrew " + withdrawAmount);

        long bal = AccountBalance - withdrawAmount;
        System.out.println("Your account balance is:" + bal);
        System.out.println();

        AccountBalance = bal;
    }

    public static void deposit() {
        Scanner input = new Scanner(System.in);
        System.out.println("Available balance is: " + AccountBalance);
        System.out.print("Enter amount you want to deposit:");
        long depositAmount = input.nextLong();
        System.out.println();
        System.out.println("You deposited " + depositAmount);

        long depositBal = AccountBalance + depositAmount;
        System.out.println("Your account balance is:" + depositBal);
        System.out.println();
    }

    public static void transfer() {
        long accountNo = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("Available balance is: " + AccountBalance);

        System.out.println("Transfer to:\n1.Same bank\n2.Other bank");
        int to = input.nextInt();
        input.nextLine(); // Consume the newline character

        if (to == 1) {
            System.out.println("Enter the Account number to transfer cash to:");
            accountNo = input.nextLong();
        } else if (to == 2) {
            System.out.println("Enter the name of the bank:");
            String bankName = input.nextLine();

            System.out.println("Enter the account number to transfer cash to:");
            accountNo = input.nextLong();
        }

        System.out.println("Enter the amount you want to transfer:");
        double amount = input.nextDouble();

        if (amount <= AccountBalance) {
            System.out.println(amount + " amount has been successfully transferred from your account to " + accountNo
                    + " \nYour account balance is:" + (AccountBalance - amount));
        }
    }

    public static void checkBal() {
        System.out.println("Available balance is: " + AccountBalance);
    }

    public static void Exit() {
        Scanner input = new Scanner(System.in);
        System.out.println("You are now logged out.\nWould you like to login again? Yes/No");
        String again = input.nextLine();

        if (again.equalsIgnoreCase("Yes")) {
            login();
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        login();
    }
}
