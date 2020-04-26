package app.sync;

public class MyThread extends Thread {

    Bank bankWork;
    int intTrans;
    long lngSleep;

    public MyThread(Bank bank, int trans, long sleep) {
        bankWork = bank;
        intTrans = trans;
        lngSleep = sleep;
    }

    public void run() {
        bankWork.calc(intTrans, lngSleep);
    }
}
