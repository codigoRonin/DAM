

public class BankThreadSpendObject extends Thread
{
    BankAccountObject account;
    
    public BankThreadSpendObject(BankAccountObject account)
    {
        this.account = account;
    }
    
    @Override
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            synchronized(account)
            {
                account.takeOutMoney(100);
            }
            try
            {
                Thread.sleep(100);
            } catch (Exception e) {}
        }
    }
}
