import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MyRandomMessage implements Runnable
{
    Random r = new Random (System.currentTimeMillis());
    @Override
    public void run()
    {
        int time = r.nextInt(10) + 1;
        try
        {
            TimeUnit.SECONDS.sleep(time);
            System.out.println("Thread waited " + time + 
                " seconds and finished.");
        } catch (Exception e) {} 
    }
}
