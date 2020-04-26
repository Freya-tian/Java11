package app.sync;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        Bank mainBank = new Bank();

        MyThread threadOne = new MyThread(mainBank, 100, 2000);
        threadOne.setName("ThreadOne");
        threadOne.setPriority(Thread.MAX_PRIORITY);
        threadOne.start();

        MyThread threadTwo = new MyThread(mainBank, 50, 300);
        threadTwo.setName("ThreadTwo");
        threadTwo.setPriority(Thread.MAX_PRIORITY);
        threadTwo.start();

        System.out.println("CurrentThread: " + Thread.currentThread().getName());
    }
}
