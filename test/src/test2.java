import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.codec.binary.Base64;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.xml.sax.SAXException;

// import javax.xml.parsers.DocumentBuilderFactory;
public class test2 {
    /**
     * @param args
     */
    private static class TrustAnyTrustManager implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[] {};
        }
    }

    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException,
            ParserConfigurationException, SAXException, IOException {
        // TODO Auto-generated method stub
        InputStream in = null;
        OutputStream out = null;
        byte[] buffer = new byte[4096];
        String str_return = " ";
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[] {new TrustAnyTrustManager() }, new java.security.SecureRandom());
            //
            URL console = new URL("https://192.168.2.174/api/hosts");
            HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
            conn.setRequestProperty(
                    "Authorization",
                    "Basic "
                            + Base64.encodeBase64String(new String("sysadmin@internal:d47a4f5b55990ea26c1585ae096601f7")
                                    .getBytes()));
            // conn.setRequestProperty("Filter", "true");
            conn.setRequestProperty("Content-type", "application/xml");
            conn.setSSLSocketFactory(sc.getSocketFactory());
            conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
            conn.connect();
            InputStream is = conn.getInputStream();
            DataInputStream indata = new DataInputStream(is);
            String ret = "";
            while (ret != null) {
                ret = indata.readLine();
                if (ret != null && !ret.trim().equals("") && !ret.contains("<?")) {
                    str_return = str_return + new String(ret.getBytes("ISO-8859-1"), "GBK") + "\r\t";
                }
            }
            conn.disconnect();
        } catch (ConnectException e) {
            System.out.println("ConnectException");
            System.out.println(e);
            // throw e;
        } catch (IOException e) {
            System.out.println("IOException");
            System.out.println(e);
            // throw e;
        } finally {
            try {
                in.close();
            } catch (Exception e) {}
            try {
                out.close();
            } catch (Exception e) {}
        }
        System.out.println(str_return);
        readStringXml(str_return, "vm", "id");
    }

    public static void readStringXml(String xml, String tag, String attribute) {
        Document doc = null;
        // 下面的是通过解析xml字符串的
        try {
            doc = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
        } // 将字符串转为XML
        Element rootElt = doc.getRootElement(); // 获取根节点
        List<Element> elments = rootElt.selectNodes(tag);
        System.out.println(elments.size());
        for (Element elment : elments) {
            System.out.println(elment.attributeValue(attribute));
        }
    }
}
