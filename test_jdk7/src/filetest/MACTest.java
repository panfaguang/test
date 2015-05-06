package filetest;

public class MACTest {
    public static void main(String[] args) {
        System.out.println(formatMAC("0:34:3e:5f:03:3d"));
    }

    public static String formatMAC(String mac) {
        // mac为空或者mac的长度等于17不需要格式化
        if (mac == null && mac.length() == 17)
            return mac;
        String[] macs = mac.split(":");
        StringBuffer macbuf = new StringBuffer();
        for (String temp : macs) {
            if (temp.length() < 2) {
                macbuf.append(temp).append("0").append(":");
            } else {
                macbuf.append(temp).append(":");
            }
        }
        mac = macbuf.substring(0, macbuf.length() - 1);
        return mac;
    }
}
