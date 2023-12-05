
import java.util.Stack;

public class DishPile 
{
    // Maximum number of dishes allowed in the pile
    public static final int MAX_DISHES = 5;
    
    Stack<Dish> pile;
    
    public DishPile()
    {
        pile = new Stack<Dish>();
    }
    
    public synchronized void wash(Dish d)
    {
        if (pile.size() == MAX_DISHES)
            try
            {
                wait();
            } catch (Exception e) {}
        pile.push(d);
        System.out.println("Washed dish #" + d.getNumber() + ", total in pile: " + pile.size());
        notifyAll();
    }
    
    public synchronized void dry()
    {
        if (pile.size() == 0)
            try
            {
                wait();
            } catch (Exception e) {}
        Dish d = pile.pop();
        System.out.println("Drying dish #" + d.getNumber() + ", total in pile: " + pile.size());
        notifyAll();
    }
}
