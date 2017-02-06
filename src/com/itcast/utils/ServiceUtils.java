package com.itcast.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.management.RuntimeErrorException;

import sun.misc.BASE64Encoder;

public class ServiceUtils {
	
	public static String MD5(String message){
		byte[] md5;
		BASE64Encoder encoder;
		try {
			MessageDigest md=MessageDigest.getInstance("md5");
			md5 = md.digest(message.getBytes());
			
			encoder = new BASE64Encoder();
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException();
		}
	}
}
