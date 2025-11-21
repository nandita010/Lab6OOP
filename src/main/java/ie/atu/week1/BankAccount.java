package ie.atu.week1;

public class BankAccount {
    private String accNo;
    private String name;
    private double balance;
    public BankAccount(String accNo, String name, double balance)
    {
        if (balance <= 0)
        {
            throw new IllegalArgumentException(("Balance must be greater than 0"));
        }
        this. accNo= accNo;
        this. name= name;
        this. balance = balance;
    }

    public BankAccount() {

    }

    public String getAccno()
    {
        return accNo;
    }

    public String getName()
    {
        return name;
    }

    public double getBalance()
    {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }
}
