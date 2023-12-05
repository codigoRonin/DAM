

public class BankAccount 
{
    int balance;
    
    public BankAccount(int balance)
    {
        this.balance = balance;
    }
    
    public synchronized void addMoney(int money)
    {
        balance += money;
        System.out.println("Money added. Current Balance: " + balance);
    }
    
    public synchronized void takeOutMoney(int money)
    {
        balance -= money;
        System.out.println("Money taken out. Current Balance: " + balance);
    }
    
    public int getBalance()
    {
        return balance;
    }
}
