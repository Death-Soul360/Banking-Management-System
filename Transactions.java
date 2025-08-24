package Bank_Management_App;

public class Transactions {
    Long accNum;
    String type;
    double amt;

    public Transactions(Long accNum, String type, double amt) {
        this.accNum = accNum;
        this.type = type;
        this.amt = amt;
    }

    public Long getAccNum() {
        return accNum;
    }

    public String getType() {
        return type;
    }

    public double getAmt() {
        return amt;
    }
}
