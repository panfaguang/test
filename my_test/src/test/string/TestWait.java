package test.string;

import java.util.ArrayList;

public class TestWait {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("11111");
        list1.add("11111");
        list1.add("11111");
        list1.add("11111");
        while (list.size() < list1.size()) {
            list.add("111");
        }
        System.out.println(list);
        // HashMap<String, String> map = new HashMap<String, String>();
        // for (int i = 0; i < 100; i++) {
        // map.put(i + "", i + "");
        // }
        // String[] test = new String[map.values().size()];
        // map.values().toArray(test);
        // System.out.println(test);
        // HashMap<String, String> map1 = new HashMap<String, String>(map);
        // map1.clear();
        // System.out.println(map1.keySet().size());
        // System.out.println(map.keySet().size());
        // final Semaphore semaphore = new Semaphore(0);
        // new Thread() {
        // public void run() {
        // try {
        // semaphore.tryAcquire(5000l, TimeUnit.MILLISECONDS);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // }
        // }.start();
        // // new Thread() {
        // // public void run() {
        // // notify();
        // // }
        // // }.start();
    }
}
