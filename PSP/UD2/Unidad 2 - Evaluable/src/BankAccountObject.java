

public class BankAccountObject 
{
    int balance;
    
    public BankAccountObject(int balance)
    {
        this.balance = balance;
    }
    
    public void addMoney(int money)
    {
        balance += money;
        System.out.println("Money added. Current Balance: " + balance);
    }
    
    public void takeOutMoney(int money)
    {
        balance -= money;
        System.out.println("Money taken out. Current Balance: " + balance);
    }
    
    public int getBalance()
    {
        return balance;
    }
}
