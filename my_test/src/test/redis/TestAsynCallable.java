package test.redis;

import java.util.concurrent.Callable;

public class TestAsynCallable implements Callable {
    private NmapCommand nmapCommand = new NmapCommand();
    String command;

    public TestAsynCallable(String command) {
        this.command = command;
    }

    public Object call() throws Exception {
        try {
            while (true) {
                nmapCommand.asynCommand(command);
                System.out.println(Thread.currentThread().getId());
                Thread.sleep(2000l);
            }
        } catch (Exception e) {
            return null;
        }
    }
}
