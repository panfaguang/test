package test.redis;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import redis.clients.jedis.BinaryJedisPubSub;

import com.antrol.redis.dto.RedisMessage;

/**
 * 
 * @author user
 *
 */
public class RedisListener extends BinaryJedisPubSub {
    private NmapBroker nmapBroker;

    public RedisListener(NmapBroker nmapBroker) {
        this.nmapBroker = nmapBroker;
    }

    // @Override
    // public void onMessage(String arg0, String arg1) {
    // // if (nmapBroker.recive(arg1)) {
    // // System.out.println("同步消息测试:" + arg0 + arg1 + "<<end");
    // // } else {
    // // System.out.println("异步消息测试:" + arg0 + arg1 + "<<end");
    // // }
    // System.out.println("当前线程名:" + Thread.currentThread().getName()
    // + new JdkSerializationRedisSerializer().deserialize(arg1.getBytes()));
    // }
    //
    // @Override
    // public void onPMessage(String arg0, String arg1, String arg2) {
    // // TODO Auto-generated method stub
    // }
    //
    // @Override
    // public void onPSubscribe(String arg0, int arg1) {
    // // TODO Auto-generated method stub
    // }
    //
    // @Override
    // public void onPUnsubscribe(String arg0, int arg1) {
    // // TODO Auto-generated method stub
    // }
    //
    // @Override
    // public void onSubscribe(String arg0, int arg1) {
    // // TODO Auto-generated method stub
    // }
    //
    // @Override
    // public void onUnsubscribe(String arg0, int arg1) {
    // // TODO Auto-generated method stub
    // }
    @Override
    public void onMessage(byte[] arg0, byte[] arg1) {
        // if (nmapBroker.recive(arg1)) {
        // System.out.println("同步消息测试:" + arg0 + arg1 + "<<end");
        // } else {
        // System.out.println("异步消息测试:" + arg0 + arg1 + "<<end");
        // }
        ByteArrayInputStream byteStream = new ByteArrayInputStream(arg1);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteStream);
            Object object = objectInputStream.readObject();
            if (object instanceof RedisMessage) {
                System.out.println(object);
            }
        } catch (Exception ex) {
            System.out.println();
        }
        System.out.println("当前线程名:" + Thread.currentThread().getName()
                + new JdkSerializationRedisSerializer().deserialize(arg1));
    }

    @Override
    public void onPMessage(byte[] arg0, byte[] arg1, byte[] arg2) {
        System.out.println("当前线程名:" + Thread.currentThread().getName()
                + new JdkSerializationRedisSerializer().deserialize(arg1));
    }

    @Override
    public void onPSubscribe(byte[] arg0, int arg1) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onPUnsubscribe(byte[] arg0, int arg1) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onSubscribe(byte[] arg0, int arg1) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onUnsubscribe(byte[] arg0, int arg1) {
        // TODO Auto-generated method stub
    }
}
