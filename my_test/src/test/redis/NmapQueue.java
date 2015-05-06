package test.redis;

import java.util.concurrent.ConcurrentHashMap;

class NmapQueue {
    private static ConcurrentHashMap<String, NmapMessage> queue = new ConcurrentHashMap<String, NmapMessage>();

    public void put(String messageId, NmapMessage obj) {
        queue.put(messageId, obj);
    }

    public NmapMessage get(String messageId) {
        return queue.get(messageId);
    }

    public void remove(String messageId) {
        queue.remove(messageId);
    }
}
