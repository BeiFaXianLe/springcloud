package com.myself.springcloud;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author zxy
 * @Date: 2020/07/27/ 22:57
 * @Description
 */
@SpringBootApplication
@EnableAdminServer
public class SpringbootAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootAdminApplication.class,args);
    }
}
