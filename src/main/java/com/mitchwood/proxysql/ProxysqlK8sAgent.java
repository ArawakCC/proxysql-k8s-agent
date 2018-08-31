package com.mitchwood.proxysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProxysqlK8sAgent {

	public static void main(String[] args) {
		SpringApplication.run(ProxysqlK8sAgent.class, args);
	}
}
