class Sub implements Runnable{
    private int n;
    private int sum = 1;
    public Sub(int a){
        n = a;
    }

    public void run(){
        for (int i=1;i<=n;i++){
            sum *= i;
        }
        System.out.println(sum);
    }
}

public class Ex06 {
    public static void main(String[] args) {
        Thread sub1 = new Thread(new Sub(5));
        Thread sub2 = new Thread(new Sub(10));

        sub1.start();
        sub2.start();
    }
}
