class MRunnable implements Runnable{
    private String threadName;
    private int repeatCount;
    private int sleepTime;

    public MRunnable(String name, int count, int time){
        this.threadName = name;
        this.repeatCount = count;
        this.sleepTime = time;
    }

    public void run(){
        for (int i=1;i<= repeatCount;i++){
            System.out.println(threadName + " is running...");

            try{
                Thread.sleep(sleepTime);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class Ex07 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MRunnable("Thread 1", 10, 1000));
        Thread t2 = new Thread(new MRunnable("Thread 2", 10, 2500));

        t1.start();
        t2.start();
    }
}
