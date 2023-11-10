public class KillableThread extends Thread 
{
    boolean finish = false;

    public void setFinish(boolean finish) 
    {
        this.finish = finish;
    }

    @Override
    public void run() 
    {
        while (!finish) 
        {
           // Thread task
        }
    }
}