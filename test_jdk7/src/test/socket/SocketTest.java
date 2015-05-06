package test.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketTest {
    public static void main(String[] args) {
        System.out.println(canConnectTCPSocket("192.168.2.41", 27017));
    }

    private static boolean canConnectTCPSocket(String hostname, int port) {
        InetSocketAddress saddr = new InetSocketAddress(hostname, port);
        Socket socket = new Socket();
        try {
            socket.connect(saddr, 1000);
            socket.setSoTimeout(1000);
            return true;
        } catch (IOException e) {
            try {
                socket.connect(saddr, 1000);
                socket.setSoTimeout(1000);
                return true;
            } catch (IOException ee) {
                try {
                    socket.connect(saddr, 1000);
                    socket.setSoTimeout(1000);
                    return true;
                } catch (IOException eee) {
                    return false;
                }
            }
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
