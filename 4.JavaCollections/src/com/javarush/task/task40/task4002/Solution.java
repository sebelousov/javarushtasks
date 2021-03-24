package com.javarush.task.task40.task4002;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* 
Опять POST, а не GET
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.sendPost("http://requestb.in/1h4qhvv1", "name=zapp&mood=good&locale=&id=777");
    }

    public void sendPost(String url, String urlParameters) throws Exception {
        HttpClient client = getHttpClient();
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> params = URLEncodedUtils.parse(urlParameters, StandardCharsets.UTF_8);

        httpPost.setEntity(new UrlEncodedFormEntity(params));


        httpPost.addHeader("User-Agent", "Mozilla/5.0");

        HttpResponse response = client.execute(httpPost);

        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String responseLine;
        while ((responseLine = bufferedReader.readLine()) != null) {
            result.append(responseLine);
        }

        System.out.println("Response: " + result.toString());
    }

//    public void sendPost(String url, String urlParameters) throws Exception {
//        HttpClient client = getHttpClient();
//        HttpGet request = new HttpGet(url);
//
//        HttpPost httpPost = new HttpPost(url);
//        List<NameValuePair> params = URLEncodedUtils.parse(urlParameters, StandardCharsets.UTF_8);
//
//        httpPost.setEntity(new UrlEncodedFormEntity(params));
//
//
//        request.addHeader("User-Agent", "Mozilla/5.0");
//
//        HttpResponse response = client.execute(request);
//
//        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//
//        StringBuffer result = new StringBuffer();
//        String responseLine;
//        while ((responseLine = bufferedReader.readLine()) != null) {
//            result.append(responseLine);
//        }
//
//        System.out.println("Response: " + result.toString());
//    }

    protected HttpClient getHttpClient() {
        return HttpClientBuilder.create().build();
    }
}
