/**
 * Created by Cloud on 23/11/2014.
 */
public class BankAccountImpl implements BankAccount {
    private String accountName;
    private double balance;


    public BankAccountImpl(String name, double balance)
    {
        this.accountName = name;
        this.balance = balance;
    }

    public String getAccountName()
    {
        return accountName;
    }

    public double getBalance()
    {
        return balance;
    }

    public void deposit(double amount)
    {
        balance = balance + amount;
    }
}
