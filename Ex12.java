class PrePaid extends Thread{
    private static int sum = 200;
    private static final Object lock = new Object();

    public void run(){
        while (getSum()>= 10){
            int fee = generateRandomFee();
            if (getSum() - fee >= 10){
                talk(fee);
            } else {
                synchronized (lock){
                    break;
                }
            }
        }
    }

    private synchronized int generateRandomFee(){
        return (int) (Math.random() * Math.min(100, getSum() - 10) + 1);
    }

    public void talk(int fee){
        synchronized (lock){
            try{
                Thread.sleep(200);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            if (getSum() - fee >= 0){
                setSum(getSum() - fee);
                System.out.println("打了" + fee + "元, 餘額" + getSum() + "元");
            }
        }
    }

    public synchronized int getSum(){
        return sum;
    }

    public synchronized void setSum(int value){
        sum = value;
    }
}

public class Ex12 {
    public static void main(String[] args) {
        PrePaid phone1 = new PrePaid();
        PrePaid phone2 = new PrePaid();
        PrePaid phone3 = new PrePaid();

        phone1.start();
        phone2.start();
        phone3.start();
    }
}
