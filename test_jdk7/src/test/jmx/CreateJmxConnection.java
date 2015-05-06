package test.jmx;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import test.string.TestFutureTask;

public class CreateJmxConnection {
    public static void main(String[] args) throws Exception {
        Map map = new HashMap();
        String jmxUrl = "service:jmx:rmi:///jndi/rmi://192.168.2.41:1099/karaf-root";
        JMXServiceURL url = new JMXServiceURL(jmxUrl);
        String proto = url.getProtocol();
        map.put(JMXConnector.CREDENTIALS, new String[] {"karaf", "karaf" });
        final JMXConnector connector = JMXConnectorFactory.connect(url, map);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS,
                new SynchronousQueue(), new ThreadPoolExecutor.AbortPolicy());
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            threadPoolExecutor.execute(new TestFutureTask(new Callable() {
                @Override
                public Object call() throws Exception {
                    MBeanServerConnection mServer = connector.getMBeanServerConnection();
                    mServer.getAttribute(new ObjectName("java.lang:type=Threading"), "ThreadCount");
                    return null;
                }
            }));
        }
        Thread.sleep(5 * 60 * 1000);
    }
}
