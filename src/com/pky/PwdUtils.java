package com.pky;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Base64.Encoder;


public class PwdUtils {
	
	public static String encryptData(String text) throws Exception{
	MessageDigest md=MessageDigest.getInstance("SHA-256");
		
		md.reset();
		
	
		System.out.println("Original Pwd ::"+text);
		
		md.update(text.getBytes());
		byte[] digest=md.digest();
		System.out.println("Digested text ::"+new String(digest));
		
		Encoder encoder=Base64.getEncoder();
		byte[] encodedDigestPwd=encoder.encode(digest);
		System.out.println("Encoded + Digest text ::"+new String(encodedDigestPwd));
		
		return new String(encodedDigestPwd);
	}
	
	public static void main(String[] args) throws Exception  {
		String pwd="india@1234";
		
		PwdUtils.encryptData(pwd);
	
	}

}
