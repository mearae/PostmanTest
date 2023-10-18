package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	// spring initializer
	// 버전 : 2.7.16
	// java : 11
	// generate -> demo.zip -> 압축 풀기 -> gradle-wrapper.properties 버전 수정, build.gradle 수정
	//
	// localhost:8080
	// ID : user
	// PS : 콘솔 security password: ~~
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
