package http;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class client1 {
    public static void main(String[] args) {
        String msg = "{\"test\":\"this is a log for test\"}";
        post(msg);
    }

    public static void post(final String msg){
        try {
            String value = URLEncoder.encode("testval...", "UTF-8");
            byte[] outbuf = new byte[]{};
            byte[] buf = ("value="+msg).getBytes("UTF-8");
            String urlPath = "https://pay.jaapanapi.com/Pay_Test_callbackTest.html";
            URL url = new URL(urlPath);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            OutputStream out = conn.getOutputStream();
            out.write(buf);
            int httpcode = conn.getResponseCode();
            System.out.println(httpcode);
            if (conn != null) {//关闭连接
                conn.disconnect();
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
