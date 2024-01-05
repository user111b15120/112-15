class Add implements Runnable{
    private int n;
    private int sum = 0;
    public Add(int a){
        n = a;
    }
    public void run(){
        for(int i=1;i<=n;i++){
            sum += i;
        }
        System.out.println(sum);
    }
}

public class Ex04 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Add(5));
        Thread thread2 = new Thread(new Add(10));

        thread1.run();
        thread2.run();
    }
}
