

import org.apache.accumulo.core.client.AccumuloException;
import org.apache.accumulo.core.client.AccumuloSecurityException;
import org.apache.accumulo.core.client.BatchWriter;
import org.apache.accumulo.core.client.BatchWriterConfig;
import org.apache.accumulo.core.client.Connector;
import org.apache.accumulo.core.client.TableExistsException;
import org.apache.accumulo.core.client.TableNotFoundException;
import org.apache.accumulo.core.client.ZooKeeperInstance;
import org.apache.accumulo.core.data.Mutation;
import org.apache.accumulo.core.data.Value;
import org.apache.hadoop.io.Text;

import com.antrol.saas.logs.secbase.model.LogResource;
import com.antrol.saas.logs.secbase.util.SecbaseConstants;
import com.antrol.saas.logs.secbase.util.SecbaseUtil;

public class SecbaseTest {
    public static void main(String[] args) {
        ZooKeeperInstance instance = new ZooKeeperInstance("test",
                "172.19.105.241:2281,172.19.105.242:2281,172.19.105.243:2281,172.19.105.244:2281,172.19.105.245:2281");
        try {
            Connector conn = instance.getConnector("test", "test");
            if (!conn.tableOperations().exists("test" + SecbaseConstants.LOG_RESOURCE)) {
                try {
                    conn.tableOperations().create("test" + SecbaseConstants.LOG_RESOURCE);
                } catch (TableExistsException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            try {
                BatchWriter bw = conn.createBatchWriter("test" + "." + SecbaseConstants.LOG_RESOURCE,
                        new BatchWriterConfig());
                bw = SecbaseUtil.getBachWriter(SecbaseConstants.LOG_RESOURCE);
                LogResource resource = new LogResource("xiaopan", "test", "test", "test", "test");
                // 主键生成
                String rowKey = resource.getResourceId() + "-" + System.currentTimeMillis();
                Mutation mu = new Mutation(new Text(rowKey));
                mu.put(new Text("resource"), new Text("resource_name"),
                        new Value(String.valueOf(resource.getResourceName()).getBytes()));
                mu.put(new Text("resource"), new Text("appName"), new Value(String.valueOf(resource.getAppName())
                        .getBytes()));
                mu.put(new Text("resource"), new Text("host"), new Value(String.valueOf((resource.getHost()))
                        .getBytes()));
                mu.put(new Text("resource"), new Text("key"), new Value(String.valueOf((resource.getKey())).getBytes()));
                bw.addMutation(mu);
                bw.close();
                System.out.println("执行完毕");
            } catch (TableNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (AccumuloException | AccumuloSecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
