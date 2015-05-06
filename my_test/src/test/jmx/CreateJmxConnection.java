package test.jmx;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class CreateJmxConnection {
    public static void main(String[] args) throws Exception {
        Map map = new HashMap();
        String jmxUrl = "service:jmx:rmi:///jndi/rmi://192.168.2.106:1099/jmxrmi";
        JMXServiceURL url = new JMXServiceURL(jmxUrl);
        String proto = url.getProtocol();
        JMXConnector connector = JMXConnectorFactory.connect(url, map);
        MBeanServerConnection mServer = connector.getMBeanServerConnection();
        meServer.g
        Set<ObjectInstance> objectInstances = mServer.queryMBeans(new ObjectName("java.lang:type=Threading"),
                null);
        System.out.println(objectInstances);
    }
}
