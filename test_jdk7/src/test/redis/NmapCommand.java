package test.redis;

class NmapCommand {
    public String syncCommand(String command) {
        NmapMessage message = new NmapMessage(command);
        NmapBroker broker = NmapBroker.getNmapBroker();
        String token = broker.send(message);
        return broker.wait(token);
    }

    public void asynCommand(String command) {
        NmapBroker broker = NmapBroker.getNmapBroker();
        broker.send(command);
    }
}
