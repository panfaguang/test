package xiaopan.test;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import org.apache.log4j.spi.LoggingEvent;

public class TestServer {
    public static void main(String[] args) throws Exception {
        ServerSocket socket = new ServerSocket(4560);
        while (true) {
            Socket client = socket.accept();
            Thread t = new Thread(new LogRunner(client));
            t.start();
        }
    }

    static class LogRunner implements Runnable {
        private ObjectInputStream ois;

        public LogRunner(Socket client) {
            try {
                this.ois = new ObjectInputStream(client.getInputStream());
            } catch (Exception e) {}
        }

        @Override
        public void run() {
            try {
                while (true) {
                    LoggingEvent event = (LoggingEvent) ois.readObject();
                    System.out.println(event.getThrowableStrRep());
                    System.out.println(event.getLoggerName() + ":   " + new Date(event.getTimeStamp()) + ":   "
                            + ":   " + event.getLevel() + ":  " + event.getMessage());
                }
            } catch (Exception e) {} finally {}
        }
    }
}
