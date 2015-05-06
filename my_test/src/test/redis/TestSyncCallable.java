package test.redis;

import java.util.concurrent.Callable;

public class TestSyncCallable implements Callable {
    private NmapCommand nmapCommand = new NmapCommand();
    String command;

    public TestSyncCallable(String command) {
        this.command = command;
    }

    public Object call() throws Exception {
        try {
            String result = nmapCommand.syncCommand(command);
            System.out.println(nmapCommand.syncCommand(command));
            Thread.sleep(2000l);
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
