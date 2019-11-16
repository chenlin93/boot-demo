package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@ComponentScan(basePackages = {"com.example.*"})
@MapperScan(basePackages = {"com.example.common"})
public class DemoApplication {

	public static Environment environment;

	public DemoApplication(Environment environment) {
		DemoApplication.environment = environment;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("正常启动成功...");
	}

}
