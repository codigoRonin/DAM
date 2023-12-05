

public class Dryer extends Thread
{
    // Total number of dishes to be dried
    int n;
    // Dish pile
    DishPile pile;
    
    public Dryer(int n, DishPile pile)
    {
        this.n = n;
        this.pile = pile;
    }
    
    @Override
    public void run()
    {
        for (int i = 1; i <= n; i++)
        {
            pile.dry();
            try
            {
                Thread.sleep(100);
            } catch (Exception e) {}
        }
       
    }
}
