package Bank_Management_App;

import java.util.*;

public class Banking_Management_Process {

    // Store Accounts and Transaction History
    private final Map<Long, Account_Details> accInfo = new TreeMap<>();
    private final Map<Long, List<Transactions>> stmt = new TreeMap<>();

    // ---------------- CREATE ACCOUNT ----------------
    public void createAccount(Account_Details acc) {
        System.out.println("\n-----------------------------------------------\n");

        if (accInfo.containsKey(acc.getAccNum())) {
            System.out.println("Account number already exists!");
            return;
        }

        accInfo.put(acc.getAccNum(), acc);
        stmt.put(acc.getAccNum(), new ArrayList<>()); // Empty statement list create

        System.out.println("Account Created Successfully!");
        System.out.println("[OK] Account " + acc.getAccNum() +
                " created for " + acc.getName() +
                " | " + acc.getAccType() +
                " | Opening Balance: ₹" + acc.getBalance());

        System.out.println("\n-----------------------------------------------");
    }

    // ---------------- DEPOSIT ----------------
    public void deposit(long accNum, double money) {
        System.out.println("\n-----------------------------------------------\n");

        if (!accInfo.containsKey(accNum)) {
            System.out.println("Account not found!");
            return;
        }

        if (money <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }

        Account_Details acc = accInfo.get(accNum);
        acc.setBalance(acc.getBalance() + money);

        // Add transaction
        stmt.get(accNum).add(new Transactions(accNum, "Deposit", money));

        System.out.println("[TXN] Deposit of ₹" + money +
                " successful. Current Balance: ₹" + acc.getBalance());

        System.out.println("\n-----------------------------------------------");
    }

    // ---------------- WITHDRAW ----------------
    public void withdraw(long accNum, double amt) {
        System.out.println("\n-----------------------------------------------\n");

        if (!accInfo.containsKey(accNum)) {
            System.out.println("Account not found!");
            return;
        }

        Account_Details acc = accInfo.get(accNum);
        if (amt <= 0 || acc.getBalance() < amt) {
            System.out.println("Invalid withdrawal amount or insufficient balance!");
            return;
        }

        acc.setBalance(acc.getBalance() - amt);

        // Add transaction
        stmt.get(accNum).add(new Transactions(accNum, "Withdraw", amt));

        System.out.println("[TXN] Withdraw of ₹" + amt +
                " successful. Current Balance: ₹" + acc.getBalance());

        System.out.println("\n-----------------------------------------------");
    }

    // ---------------- CHECK BALANCE ----------------
    public void checkBalance(long accNum) {
        System.out.println("\n-----------------------------------------------\n");

        if (!accInfo.containsKey(accNum)) {
            System.out.println("Account not found!");
            return;
        }

        Account_Details acc = accInfo.get(accNum);
        System.out.println("Account No   : " + acc.getAccNum());
        System.out.println("Holder Name  : " + acc.getName());
        System.out.println("Account Type : " + acc.getAccType());
        System.out.println("Current Bal  : ₹" + acc.getBalance());

        System.out.println("\n-----------------------------------------------");
    }

    // ---------------- TRANSFER ----------------
    public void transfer(long acc1, long acc2, double transAmt) {
        System.out.println("\n-----------------------------------------------\n");

        if (!accInfo.containsKey(acc1)) {
            System.out.println("Sender's account not found!");
            return;
        }
        if (!accInfo.containsKey(acc2)) {
            System.out.println("Receiver's account not found!");
            return;
        }
        if (transAmt <= 0 || accInfo.get(acc1).getBalance() < transAmt) {
            System.out.println("Invalid transfer amount or insufficient balance!");
            return;
        }

        Account_Details acc1Info = accInfo.get(acc1);
        Account_Details acc2Info = accInfo.get(acc2);

        // Update balances
        acc1Info.setBalance(acc1Info.getBalance() - transAmt);
        acc2Info.setBalance(acc2Info.getBalance() + transAmt);

        // Add to transaction history
        stmt.get(acc1).add(new Transactions(acc1, "Transfer Out", transAmt));
        stmt.get(acc2).add(new Transactions(acc2, "Transfer In", transAmt));

        // Success message
        System.out.println("[TXN SUCCESS] ₹" + transAmt +
                " transferred from " + acc1 + " to " + acc2);
        System.out.println("Sender Balance  : ₹" + acc1Info.getBalance());
        System.out.println("Receiver Balance: ₹" + acc2Info.getBalance());

        System.out.println("\n-----------------------------------------------");
    }

    // ---------------- MINI STATEMENT ----------------
    public void miniStmt(long accNum) {
        System.out.println("\n-----------------------------------------------\n");

        if (!accInfo.containsKey(accNum)) {
            System.out.println("Account not found!");
            return;
        }

        Account_Details acc = accInfo.get(accNum);
        List<Transactions> transactions = stmt.get(accNum);

        System.out.println("Account: " + acc.getAccNum() +
                " | Holder: " + acc.getName());
        System.out.println("----------- Mini Statement -----------");

        if (transactions.isEmpty()) {
            System.out.println("No transactions found!");
        } else {
            for (Transactions t : transactions) {
                System.out.println(t.getType() + " : ₹" + t.getAmt());
            }
        }

        System.out.println("Current Balance: ₹" + acc.getBalance());
        System.out.println("\n-----------------------------------------------");
    }

    // ---------------- CLOSE ACCOUNT ----------------
    public void closeAcc(long accNum) {
        System.out.println("\n-----------------------------------------------\n");

        if (!accInfo.containsKey(accNum)) {
            System.out.println("Account not found!");
            return;
        }

        accInfo.remove(accNum);
        stmt.remove(accNum);

        System.out.println("Account " + accNum + " closed successfully!");

        System.out.println("\n-----------------------------------------------");
    }
}
