package test.redis;

import redis.clients.jedis.JedisPool;

class NmapBroker {
    private static final NmapBroker broker = new NmapBroker();
    private static JedisPool jedisPool;

    private NmapBroker() {
        queue = new NmapQueue();
    }

    public static void init(JedisPool jedis) {
        jedisPool = jedis;
    }

    public static NmapBroker getNmapBroker() {
        return broker;
    }

    public String send(NmapMessage message) {
        String data = "S" + message.getMessageId() + message.getMessage();
        queue.put(message.getMessageId(), message);
        jedisPool.getResource().publish("AntrolScanCommandQueue", data);
        return message.getMessageId();
    }

    public void send(String command) {
        String data = "A" + command;
        jedisPool.getResource().publish("AntrolScanCommandQueue", data);
    }

    public String wait(String messageId) {
        NmapMessage messageObj = queue.get(messageId);
        String result = messageObj.waitResult();
        queue.remove(messageId);
        return result;
    }

    public Boolean recive(String result) {
        Boolean ret = false;
        if (result.charAt(0) == 'S') {
            NmapMessage messageObj = queue.get(result.substring(1, 24));
            result = result.substring(24, result.length());
            messageObj.setResult(result);
            ret = true;
        }
        return ret;
    }

    private NmapQueue queue;
}
