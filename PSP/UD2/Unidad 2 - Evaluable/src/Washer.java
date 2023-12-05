

public class Washer extends Thread
{
    // Number of dishes to be washed
    int n;
    // Dish pile
    DishPile pile;
    
    public Washer(int n, DishPile pile)
    {
        this.n = n;
        this.pile = pile;
    }
    
    @Override
    public void run()
    {
        for (int i = 1; i <= n; i++)
        {
            Dish d = new Dish(i);
            pile.wash(d);
            try
            {
                Thread.sleep(50);
            } catch (Exception e) {}
        }
    }
}
