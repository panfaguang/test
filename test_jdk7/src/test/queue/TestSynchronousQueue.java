package test.queue;

import java.util.concurrent.SynchronousQueue;

public class TestSynchronousQueue {
    static SynchronousQueue<String> queue = new SynchronousQueue<String>();

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        queue.put(i + "");
                        System.out.println(i);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                for (int i = 100; i < 200; i++) {
                    try {
                        queue.put(i + "");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t3 = new Thread() {
            public void run() {
                while (true) {
                    try {
                        System.out.println(queue.take());
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();
        t1.start();
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // t3.start();
    }
}
