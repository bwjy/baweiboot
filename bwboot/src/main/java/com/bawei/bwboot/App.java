package com.bawei.bwboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Tommy
 * @date 2018-08-05
 */
@SpringBootApplication
@EnableAsync
@MapperScan("com.bawei.bwboot.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
