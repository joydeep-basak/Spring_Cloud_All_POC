package com.javainuse.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.javainuse.services.RemoteCallService;

@RestController
public class ConsumerControllerClient {

	@Autowired
	private RemoteCallService loadBalancer;

	public void getEmployee() throws RestClientException, IOException {

		try {
			Employee emp = loadBalancer.getData();
			System.out.println(emp.getEmpId());
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}