package test.httpConnection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class TestHttp {
    public static void main(String[] args) throws HttpException, IOException {
        HttpClient httpClient = new HttpClient();
        // httpClient.getHostConfiguration().setProxy("localhost", 808);
        // // 需要验证
        // UsernamePasswordCredentials creds = new UsernamePasswordCredentials("admin", "admin");
        // httpClient.getState().setProxyCredentials(AuthScope.ANY, creds);
        httpClient.getState().setCredentials(new AuthScope("192.168.2.113", 8161, AuthScope.ANY_REALM),
                new UsernamePasswordCredentials("admin", "admin"));
        httpClient.getParams().setAuthenticationPreemptive(true);
        // 设置http头
        List<Header> headers = new ArrayList<Header>();
        headers.add(new Header("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)"));
        httpClient.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
        GetMethod method = new GetMethod("http://192.168.2.106:8161/admin");
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
        try {
            int statusCode = httpClient.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                System.out.println("Method failed code=" + statusCode + ": " + method.getStatusLine());
            } else {
                // System.out.println(new String(method.getResponseBody(), "utf8"));
                String body = method.getResponseBodyAsString();
                body = body.split("<td>Version</td>")[1].trim().split("</b></td>")[0].split("<td><b>")[1];
                System.out.println(body);
            }
        } finally {
            method.releaseConnection();
        }
    }
}
