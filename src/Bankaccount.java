import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bankaccount  implements Serializable {
    private List<Transaction> transactions = new ArrayList<Transaction>();
    public  List<Transaction> getTransactions() {
        return transactions;
    }
    private String name;
    private double balance;
    private Integer accountnumber;
    private Integer pin;
    private Accounttype type;

    public Bankaccount(String name, double balance, Integer accountnumber, Integer pin, Accounttype type) {
        this.name = name;
        this.balance = balance;
        this.accountnumber = accountnumber;
        this.pin = pin;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Integer getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(Integer accountnumber) {
        this.accountnumber = accountnumber;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public Accounttype getType() {
        return type;
    }

    public void setType(Accounttype type) {
        this.type = type;
    }
}
