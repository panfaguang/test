import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class CreateJmxConnection {
    public static void main(String[] args) throws Exception {
        Map map = new HashMap();
        String jmxUrl = "service:jmx:rmi:///jndi/rmi://172.19.103.55:10991/karaf-root";
        JMXServiceURL url = new JMXServiceURL(jmxUrl);
        String proto = url.getProtocol();
        map.put(JMXConnector.CREDENTIALS, new String[] {"karaf", "karaf" });
        final JMXConnector connector = JMXConnectorFactory.connect(url, map);
        System.out.println(connector.getMBeanServerConnection().getMBeanCount());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS,
                new SynchronousQueue(), new ThreadPoolExecutor.AbortPolicy());
    }
}
