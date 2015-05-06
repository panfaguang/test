package test.redis;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.pool.impl.GenericObjectPool.Config;

import redis.clients.jedis.BinaryJedisPubSub;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.SafeEncoder;

import com.antrol.redis.dto.BrokerConstants;

public class RedisTestMain {
    static ShardedJedisPool shardedJedisPool;
    static JedisPool jedisPool;

    public static void main(String[] args) {
        starting();
        NmapBroker.init(jedisPool);
        new Thread() {
            public void run() {
                while (true) {
                    // subscribe(new RedisListener(NmapBroker.getNmapBroker()), new String[] {"AntrolScanResultQueue"
                    // });
                    // try {
                    // Thread.sleep(5000l);
                    // } catch (InterruptedException e) {
                    // e.printStackTrace();
                    // }
                    String[] channels = new String[] {"testChannel", "testChannel1", BrokerConstants.COMMAND_ATOS_QUEUE };
                    final byte[][] cs = new byte[channels.length][];
                    for (int i = 0; i < cs.length; i++) {
                        cs[i] = SafeEncoder.encode(channels[i]);
                    }
                    Jedis jedis = jedisPool.getResource();
                    jedis.subscribe(new RedisListener(NmapBroker.getNmapBroker()), cs);
                }
            }
        }.start();
        // BinaryJedis jedis = new BinaryJedis("192.168.2.41", 6379);
        // Jedis jedis = jedisPool.getResource();
        // String messageStr = JsonUtil.convertObjToString(new TestMessage());
        // jedis.publish("testChannel".getBytes(), "1111111111".getBytes());
        // jedis.pushmq("testChannel".getBytes(), new JdkSerializationRedisSerializer().serialize("11111111111"));
        // jedis.publish("testChannel", "1111111111111111111111");
        // System.out.println("11111111");
        // subscribe(new RedisListener(NmapBroker.getNmapBroker()), new String[] {"AntrolScanResultQueue" });
        // try {
        // Thread.sleep(10000l);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // starting();
        // try {
        //
        // jedisPool.getResource();
        // } catch (Exception e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // while (true) {
        // publish("AntrolScanCommandQueue",
        // "nmap -sS -O -traceroute --disable-arp-ping 192.168.2.248 -oX /home/opt/nmap-result"
        // + System.currentTimeMillis() + ".xml");
        // try {
        // Thread.sleep(10000l);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        // }
    }

    /**
     * 启动。
     */
    public static void starting() {
        try {
            Config poolConfig = new Config();
            poolConfig.minIdle = Integer.valueOf("1");
            poolConfig.maxActive = Integer.valueOf("5");
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

    public void publish(String channel, String message) {
        Jedis jedis = null;
        boolean isSend = false;
        while (!isSend) {
            try {
                jedis = jedisPool.getResource();
                jedis.publish(channel, message);
                isSend = true;
            } catch (Exception e) {
                try {
                    Thread.sleep(60000l);
                } catch (Exception e1) {}
                if (jedis != null) {
                    jedisPool.returnResource(jedis);
                    jedis = null;
                }
            } finally {
                if (jedis != null) {
                    jedisPool.returnResource(jedis);
                    jedis = null;
                }
            }
        }
    }

    public static void subscribe(BinaryJedisPubSub listener, String channels) {
        Jedis jedis = null;
        while (true) {
            try {
                jedis = jedisPool.getResource();
                jedis.psubscribe(listener, channels.getBytes());
            } catch (Exception e1) {
                e1.printStackTrace();
                try {
                    Thread.sleep(60000l);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (jedis != null) {
                    jedisPool.returnResource(jedis);
                    jedis = null;
                }
            } finally {
                if (jedis != null) {
                    jedisPool.returnResource(jedis);
                    jedis = null;
                }
            }
        }
    }

    public static byte[] ObjectToByte(java.lang.Object obj) {
        byte[] bytes = null;
        try {
            // object to bytearray
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);
            bytes = bo.toByteArray();
            bo.close();
            oo.close();
        } catch (Exception e) {
            System.out.println("translation" + e.getMessage());
            e.printStackTrace();
        }
        return bytes;
    }
}
