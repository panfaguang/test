import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class Test {
    /**
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        // TODO Auto-generated method stub
        HttpClient client = new HttpClient();
        StringBuilder sb = new StringBuilder();
        InputStream ins = null;
        // Create a method instance.
        GetMethod method = new GetMethod("http://192.168.5.143/api/");
        // Provide custom retry handler is necessary
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        method.addRequestHeader(
                "Authorization",
                "Basic "
                        + Base64.encodeBase64String(new String("admin@internal:f371338a7993b39f70856cf52b30b8f8")
                                .getBytes()));
        // method.addRequestHeader("Filter","true");
        method.addRequestHeader("Content-type", "application/xml");
        try {
            // Execute the method.
            // System.out.println(method);
            int statusCode = client.executeMethod(method);
            System.out.println(statusCode);
            if (statusCode == HttpStatus.SC_OK) {
                String s = method.getResponseBodyAsString();
                sb.append(s);
            } else {
                System.err.println("Response Code: " + statusCode);
            }
        } catch (HttpException e) {
            System.err.println("Fatal protocol violation: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Fatal transport error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Fatal transport error: " + e.getMessage());
        } finally {
            method.releaseConnection();
            if (ins != null) {
                try {
                    ins.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        System.out.println(sb.toString());
    }
}
