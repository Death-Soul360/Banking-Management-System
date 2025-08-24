package Bank_Management_App;

public class Account_Details {
    long accNum;
    String name;
    String accType;
    double balance;

    public Account_Details(long accNum, String name, String accType, double balance) {
        this.accNum = accNum;
        this.name = name;
        this.accType = accType;
        this.balance = balance;
    }

    public long getAccNum() {
        return accNum;
    }

    public String getName() {
        return name;
    }

    public String getAccType() {
        return accType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
