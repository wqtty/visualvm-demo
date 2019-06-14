package org.wqtty.visualvmdemo;

import java.util.Random;

/**
 * @author quentinwu
 * @date 2019-06-14
 */
public class Leaker {
    private String a;

    public Leaker() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        this.a = String.valueOf(random.nextInt());
    }
}
