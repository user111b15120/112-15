class M1Runnable implements Runnable{
    private String speak;
    private int repeatCount;
    private long time;

    public M1Runnable(String speak, int count, int time){
        this.speak = speak;
        this.repeatCount = count;
        this.time = time;
    }

    public void run(){
        for (int i=1;i<= repeatCount;i++){
            System.out.println(speak + " " + i);

            try{
                Thread.sleep(time);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class Ex10 {
    public static void main(String[] args) {
        Thread M1Runnable1 = new Thread(new M1Runnable("Hello", 5, 1000));
        Thread M1Runnable2 = new Thread(new M1Runnable("Good bye", 5, 2500));

        M1Runnable1.start();
        M1Runnable2.start();
    }
}
