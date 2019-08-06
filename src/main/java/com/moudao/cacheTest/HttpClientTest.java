package com.moudao.cacheTest;

import com.google.common.annotations.VisibleForTesting;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * http单元测试
 * author: MrWang
 * date: 2018/4/6 22:38
 */
public class HttpClientTest {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        /*HttpPost post = new HttpPost("http://localhost:8080/person/save");
        Person person = new Person();
        person.setName("tom");
        person.setCreateTime(new Date());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(person);
        byte[] bytes = baos.toByteArray();
        HttpEntity entity = new ByteArrayEntity(bytes);
        CloseableHttpResponse response = client.execute(post);
        String s = EntityUtils.toString(response.getEntity());
        System.out.println(s);*/

        HttpGet get = new HttpGet("http://localhost:8080/person/18");
        CloseableHttpResponse httpResponse = client.execute(get);
        System.out.println(EntityUtils.toString(httpResponse.getEntity()));
    }


}
