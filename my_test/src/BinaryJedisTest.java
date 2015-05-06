import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import redis.clients.jedis.BinaryJedis;
import test.redis.TestMessage;

import com.antrol.util.json.JsonUtil;

public class BinaryJedisTest {
    public static void main(String[] args) {
        BinaryJedis jedis = new BinaryJedis("192.168.2.41", 6379);
        // Jedis jedis = jedisPool.getResource();
        String messageStr = JsonUtil.convertObjToString(new TestMessage());
        // jedis.publish("testChannel".getBytes(), "1111111111".getBytes());
        jedis.pushmq("testChannel".getBytes(), new JdkSerializationRedisSerializer().serialize("11111111111"));
    }
}
