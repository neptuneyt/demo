package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//包含@Configuration、@EnableAutoConfiguration、@ComponentScan，通常用在主类上
@SpringBootApplication
public class DemoApplication{

	//应用运行主程序
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
