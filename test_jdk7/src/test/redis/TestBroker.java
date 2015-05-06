package test.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.pool.impl.GenericObjectPool.Config;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

public class TestBroker {
    static ExecutorService threadPool = Executors.newCachedThreadPool();
    static ShardedJedisPool shardedJedisPool;
    static JedisPool jedisPool;

    public static void main(String[] args) {
        starting();
        NmapBroker.init(jedisPool);
        new Thread() {
            public void run() {
                while (true) {
                    subscribe(new RedisListener(NmapBroker.getNmapBroker()), new String[] {"AntrolScanResultQueue" });
                    try {
                        Thread.sleep(5000l);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    starting();
                }
            }
        }.start();
        // for (int i = 1; i < 3000; i++) {
        // threadPool.submit(new TestSyncCallable("nmap -sn --ttl 20 -T5 192.168.1." + i));
        // // try {
        // // Thread.sleep(30l);
        // // } catch (InterruptedException e) {
        // // System.out.println(e.getMessage());
        // // }
        // }
        for (int i = 1; i < 2; i++) {
            threadPool.submit(new TestSyncCallable("nmap -sU -p 123192.168.2.107"));
        }
    }

    /**
     * 启动。
     */
    public static void starting() {
        try {
            Config poolConfig = new Config();
            poolConfig.minIdle = Integer.valueOf("5");
            poolConfig.maxActive = Integer.valueOf("200");
            poolConfig.maxWait = Integer.valueOf("1000");
            poolConfig.testOnBorrow = Boolean.valueOf("1");
            String host = "192.168.2.41";
            int port = Integer.valueOf("6379");
            List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
            JedisShardInfo si = new JedisShardInfo(host, port);
            shards.add(si);
            shardedJedisPool = new ShardedJedisPool(poolConfig, shards);
            jedisPool = new JedisPool(poolConfig, host, port);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void subscribe(RedisListener listener, String[] channels) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.subscribe(listener, channels);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            while (true) {
                try {
                    Thread.sleep(60 * 1000l);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        } finally {
            if (jedis != null) {
                jedisPool.returnResource(jedis);
                jedis = null;
            }
        }
    }
}
