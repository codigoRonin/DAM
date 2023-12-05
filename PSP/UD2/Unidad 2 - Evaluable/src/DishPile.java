
public class DishPile 
{
    // Maximum number of dishes allowed in the pile
   
    public static final int MAX_DISHES = 5;
    private Dish[] dishArray;
    private int count;

    public DishPile() {
        dishArray = new Dish[MAX_DISHES];
        count = 0;
    }

    public synchronized void wash(Dish d) {
        while (count == MAX_DISHES) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        dishArray[count] = d;
        count++;
        System.out.println("Washed dish #" + d.getNumber() + ", total in array: " + count);
        notifyAll();
    }

    public synchronized void dry() {
        while (count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Dish d = dishArray[count - 1];
        count--;
        dishArray[count] = null; // Remove the reference to the dried dish
        System.out.println("Drying dish #" + d.getNumber() + ", total in array: " + count);
        notifyAll();
    }
}
