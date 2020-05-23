package thread.demo2;

import java.lang.management.ThreadMXBean;

/**
 * 用一句话描述次类
 * @author lu
 * @version 1.0
 */
public class TestThread {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread t1 = new T1("线程1");
        Thread t2 = new T2("线程2");
        t1.setPriority(10);
        t2.setPriority(1);
        t2.start();
        t1.start();
    }
}


class T1 extends Thread {


    public T1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0; i < 50; i++) {
            System.out.println("["+i+"]"+"名称="+Thread.currentThread().getName()
                    + " | " + "优先级="+Thread.currentThread().getPriority()
                    + " | " + "状态="+Thread.currentThread().getState());
        }

    }
}

class T2 extends Thread {


    public T2(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0; i < 50; i++) {
            System.out.println("["+i+"]"+"名称="+Thread.currentThread().getName()
                    + " | " + "优先级="+Thread.currentThread().getPriority()
                    + " | " + "状态="+Thread.currentThread().getState());
        }

    }
}
