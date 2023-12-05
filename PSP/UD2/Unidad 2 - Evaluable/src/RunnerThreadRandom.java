

import java.util.Random;

public class RunnerThreadRandom extends Thread
{
    // Thread current number
    int num;
    // Our own thread priority
    int priority;
    
    public RunnerThreadRandom(String name, int priority)
    {
        this.setName(name);
        num = 1;
        
        if (priority < 1)
            this.priority = 1;
        else if (priority > 10)
            this.priority = 10;
        else
            this.priority = priority;
    }
    
    public String getRunnerName()
    {
        return this.getName();
    }
    
    public int getRunnerNumber()
    {
        return num;
    }
    
    @Override
    public void run()
    {
        Random r = new Random(System.currentTimeMillis());
        while (num < 1000)
        {
            // Generate a random number, and if it is greater or equal than
            // thread priority, then sleep/yield
            int number = r.nextInt(10) + 1;
            if (number >= priority)
                //Thread.yield();
                try { Thread.sleep(5); } catch (Exception e) {};
            try {
                Thread.sleep((int)(Math.random()*10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num++;
        }
    }
}