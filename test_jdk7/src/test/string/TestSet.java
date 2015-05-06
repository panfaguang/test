package test.string;

import java.util.HashMap;
import java.util.Map;

import org.snmp4j.smi.OID;

public class TestSet {
    public static void main(String[] args) {
        OID[] a = {new OID("1.3.6.1.2.1.25.2.3.1.4"), new OID("1.3.6.1.2.1.25.2.3.1.5"),
                new OID("1.3.6.1.2.1.25.2.3.1.6") };
        OID[] b = {new OID("1.3.6.1.2.1.25.2.3.1.4"), new OID("1.3.6.1.2.1.25.2.3.1.5"),
                new OID("1.3.6.1.2.1.25.2.3.1.6") };
        Map<String[], String> map = new HashMap<String[], String>();
        map.put(a, "1");
        System.out.println(map.get(b));
        // System.out.println(Arrays.toString(new String[] {"111", "1111" }));
        // System.out.println("192.168.".contains("."));
        // List<String> list = new ArrayList<String>();
        // long start = System.currentTimeMillis();
        // for (int i = 0; i < 10000; i++) {
        // list.add("1111111111111111111111111111111111111111111111111111111111111111");
        // }
        // PriorityBlockingQueue()
        // new LinkedBlockingQueue(1)
        // // new SynchronousQueue(),
        // ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS,
        // new SynchronousQueue(), new ThreadPoolExecutor.AbortPolicy());
        // long start = System.currentTimeMillis();
        // for (int i = 0; i < 10000; i++) {
        // threadPoolExecutor.execute(new TestFutureTask(new Callable() {
        // @Override
        // public Object call() throws Exception {
        // Thread.sleep(10000);
        // return null;
        // }
        // }));
        // }
        // try {
        // Thread.sleep(11000);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // System.out.println(threadPoolExecutor.getActiveCount());
        // System.out.println(threadPoolExecutor.getLargestPoolSize());
        // System.out.println(threadPoolExecutor.getQueue().size());
        // System.out.println(System.currentTimeMillis() - start);
        // while (true) {
        // try {
        // Thread.sleep(1000);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // System.out.println(threadPoolExecutor.getPoolSize());
        // }
        // System.out.println(System.currentTimeMillis() - start);
        // Object sssa = new String();
        // System.out.println(Double.NaN);
        // System.out.println("S000000yyyyMMddhhmmssSSSw".substring(24));
        // Set<String> set = new HashSet<String>();
        // Set<String> a = set;
        // set = null;
        // System.out.println("a=" + a);
        // System.out.println(new Date(1411705920000l));
        // System.out.println("-11".replace("-", ""));
        // System.out.println("globalLock".split("\\.").length);
        // // set.add("aaaa");
        // // set.add("bbb");
        // String str = set.toString();
        // System.out.println(str.substring(1, str.length() - 1));
        // StringBuffer sbf = new StringBuffer();
        // sbf.append("aa").append("bbb");
        // System.out.println(sbf);
        // String a = sbf.toString().substring(0, sbf.toString().lastIndexOf("b"));
        // System.out.println(a);
        // String[] strs = new String[] {"192.168.2.111", "192.168.3.2", "172.19.2.0", "172.19.2.3" };
        // Set set = new HashSet();
        // for (String str : strs) {
        // str = str.substring(0, str.lastIndexOf("."));
        // System.out.println(str);
        // set.add(str);
        // }
        // String a = "<type arch='x86_64' machine='rhel6.5.0'>hvm</type> <mac address='52:54:00:f9:9a:99'/>";
        // String mac = a.substring(a.indexOf("address='") + "address='".length(), a.lastIndexOf("'"));
        // System.out.println(mac);
        // System.out.println(new Date(1408515480000l));
        // System.out.println("111111111111111111111111111111".substring("111111111111111111111111111111".length() -
        // 6));
    }
}
