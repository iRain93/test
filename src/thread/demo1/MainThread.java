package thread.demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 用一句话描述次类
 *
 * @author lu
 * @version 1.0
 */
public class MainThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread1().start();
        new Thread(new Thread2()).start();
        FutureTask<String> thread3 = new FutureTask<String>(new Thread3());
        new Thread(thread3).start();
        System.out.println(thread3.get());
    }
}

class Thread1 extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("线程1::run...");
    }
}

class Thread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("线程2::"+"run...");
    }
}

class Thread3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("线程3::run...");
        return "SUCCESS";
    }
}
