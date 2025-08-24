package Bank_Management_App;

import java.util.Scanner;

public class Banking_Management_System {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        Banking_Management_Process bmp = new Banking_Management_Process();

        System.out.println("===============================");
        System.out.println("   SIMPLE BANKING SYSTEM DEMO   ");
        System.out.println("===============================");
        System.out.println("========= BANK MENU =========");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. Transfer Money");
        System.out.println("6. Mini Statement");
        System.out.println("7. Close Account");
        System.out.println("8. Exit");
        System.out.println("=============================");

        while (true) {
            System.out.print("\nEnter your choice: ");
            int ch = scr.nextInt();
            System.out.println("\n=============================\n");

            switch (ch) {
                case 1:
                    System.out.print("Enter account no: ");
                    long accNum = scr.nextLong();
                    System.out.print("Enter your name: ");
                    scr.nextLine(); // to consume newline
                    String name = scr.nextLine();
                    System.out.print("Enter account type ('Savings'/'Current'): ");
                    String accType = scr.next();
                    System.out.print("Enter initial amount to deposit: ");
                    double balance = scr.nextDouble();
                    bmp.createAccount(new Account_Details(accNum, name, accType, balance));
                    break;

                case 2:
                    System.out.print("Enter account no: ");
                    long accNo = scr.nextLong();
                    System.out.print("Enter amount to deposit: ");
                    double money = scr.nextDouble();
                    bmp.deposit(accNo, money);
                    break;

                case 3:
                    System.out.print("Enter account no: ");
                    long num = scr.nextLong();
                    System.out.print("Enter amount to withdraw: ");
                    double amt = scr.nextDouble();
                    bmp.withdraw(num, amt);
                    break;

                case 4:
                    System.out.print("Enter account no: ");
                    long Acc = scr.nextLong();
                    bmp.checkBalance(Acc);
                    break;

                case 5:
                    System.out.print("Enter sender's account no: ");
                    long acc1 = scr.nextLong();
                    System.out.print("Enter receiver's account no: ");
                    long acc2 = scr.nextLong();
                    System.out.print("Enter amount to transfer: ");
                    double transAmt = scr.nextDouble();
                    bmp.transfer(acc1, acc2, transAmt);
                    break;

                case 6:
                    System.out.print("Enter account no: ");
                    long AccNo = scr.nextLong();
                    bmp.miniStmt(AccNo);
                    break;

                case 7:
                    System.out.print("Enter account no: ");
                    long Accnum = scr.nextLong();
                    bmp.closeAcc(Accnum);
                    break;

                case 8:
                    System.out.println("Thank you for using our Banking System!");
                    scr.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
