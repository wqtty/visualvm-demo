package org.wqtty.visualvmdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author quentinwu
 * @date 2019-05-15
 */
@SpringBootApplication
public class VisualvmDemoApplication implements CommandLineRunner {


    @Autowired
    private DemoFuncs demoFuncs;

    public static void main(String[] args) {
        SpringApplication.run(VisualvmDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            demoFuncs.httpRequest();
            demoFuncs.consumeSomeCPU();
            demoFuncs.combination();
            demoFuncs.createMemoryLeak();
        }
    }
}
