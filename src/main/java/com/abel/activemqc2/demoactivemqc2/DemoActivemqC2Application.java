package com.abel.activemqc2.demoactivemqc2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.ConsumerService;

import javax.jms.JMSException;

@SpringBootApplication
public class DemoActivemqC2Application {

	public static void main(String[] args) throws JMSException {
		SpringApplication.run(DemoActivemqC2Application.class, args);
		ConsumerService consumerService = new ConsumerService();
	}
}
