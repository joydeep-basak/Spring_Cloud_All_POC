package com.javainuse;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.javainuse.controllers.ConsumerControllerClient;

@SpringBootApplication
@EnableFeignClients
public class SpringBootHelloWorldApplication {

	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext ctx = SpringApplication.run(
				SpringBootHelloWorldApplication.class, args);
		
		 ExecutorService executorService = Executors.newFixedThreadPool(20);
		 for (int i = 0; i  < 30;  i++) {
	        executorService.execute(new Runnable() {  
	              
	            @Override  
	            public void run() {  
	            	ConsumerControllerClient consumerControllerClient=ctx.getBean(ConsumerControllerClient.class);
	        		System.out.println(consumerControllerClient);
	        		try {
						consumerControllerClient.getEmployee();
					} catch (RestClientException | IOException e) {
						e.printStackTrace();
					}
	            }  
	        });  
		 }
		
		
	}
	
	@Bean
	public  ConsumerControllerClient  consumerControllerClient()
	{
		return  new ConsumerControllerClient();
	}
}
