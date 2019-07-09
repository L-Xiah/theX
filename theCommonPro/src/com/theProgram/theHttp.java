package com.theProgram;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class theHttp {

    /**
     * 通过服务器地址链接内容
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        BasicCookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build();
        try {
//            HttpGet httpget = new HttpGet("http://intranet.shanghai-electric.com/cn/Pages/Default.aspx");
            HttpGet httpget = new HttpGet("http://10.0.15.37/spm-web/login.do");
            CloseableHttpResponse response1 = httpclient.execute(httpget);
            try {
                HttpEntity entity = response1.getEntity();

                System.out.println("Login form get: " + response1.getStatusLine());

                System.out.println("Initial set of cookies:");
                List<Cookie> cookies = cookieStore.getCookies();
                if (cookies.isEmpty()) {
                    System.out.println("None");
                } else {
                    for (int i = 0; i < cookies.size(); i++) {
                        System.out.println("- " + cookies.get(i).toString());
                    }
                }

                //输出网页源码
                String result = EntityUtils.toString(response1.getEntity(), "utf-8");
                System.out.println(result);
// 关闭EntityUtils<br>                EntityUtils.consume(entity);

            } finally {
                response1.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}