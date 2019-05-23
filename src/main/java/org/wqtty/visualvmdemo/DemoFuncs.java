package org.wqtty.visualvmdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;

/**
 * @author quentinwu
 * @date 2019-05-15
 */
@Slf4j
@Component
public class DemoFuncs {

    private HashMap<Integer, Integer> holder = new HashMap<Integer, Integer>();

    void httpRequest() {
        String URL = "http://www.baidu.com";
        HttpURLConnection con = null;
        try {
            URL url = new URL(URL);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            log.info("GET {} got response code:{}", URL, responseCode);
        } catch (Exception e) {
            log.error("get www.baidu.com failed.", e);
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }

    void consumeSomeCPU() {
        long sum = 0;
        for (long i = 0; i < 100000000L; i++) {
            sum += i;
        }
    }

    void combination() {
        httpRequest();
        consumeSomeCPU();
    }

    void createMemoryLeak() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        for (int i = 0; i < 10000; i++) {
            holder.put(random.nextInt(), random.nextInt());
        }
    }
}
