package hazelcast_test;

import java.util.Set;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.HazelcastInstance;

public class CLientTest {
    public static void main(String[] args) {
        ClientConfig clientConfig = new ClientConfig();
        // caster4,caster5,caster6 172.19.106.110 antcaster/antcaster
        clientConfig.addAddress("172.19.106.110:5701");
        clientConfig.setGroupConfig(new GroupConfig("antcaster", "antcaster"));
        final HazelcastInstance hazelcastClient = HazelcastClient.newHazelcastClient(clientConfig);
        Set<String> set = hazelcastClient.getSet("antrol-license");
        for (String key : set) {
            System.out.println(key);
        }
        System.out.println(set.size());
    }
}
