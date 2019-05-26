package com.revature.services;

import com.amazonaws.auth.AWSCredentials;

public class MyCredentials implements AWSCredentials {
	
	public MyCredentials(){
		super();
	}
	
	public String getAWSAccessKeyId() {
		return System.getenv("A");
	}

	public String getAWSSecretKey() {
		return System.getenv("B");
	}
}