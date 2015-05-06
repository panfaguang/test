package test.string;

import java.security.MessageDigest;

public class TestWait {
    public static void main(String[] args) {
        System.out.println(MD5("sigma2012$"));
    }

    public final static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String formatMAC(String mac) {
        // mac为空或者mac的长度等于17不需要格式化
        if (mac == null || mac.length() == 17 || "".equals(mac.trim()))
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
