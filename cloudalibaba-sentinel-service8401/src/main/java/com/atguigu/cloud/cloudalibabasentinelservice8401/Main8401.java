package com.atguigu.cloud.cloudalibabasentinelservice8401;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Main8401 {

	public static void main(String[] args) {
		SpringApplication.run(Main8401.class, args);
	}

}
