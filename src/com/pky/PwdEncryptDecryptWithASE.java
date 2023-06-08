package com.pky;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class PwdEncryptDecryptWithASE {
	
	private static final String SECRET_KEY="aesEncryptionKey";   //any value as secret key but size is 16
	private static final String INIT_VECTOR="encryptionIntVec";		
//**************************************Encryption********************************************	
	public static String encryptMsg(String msg) throws Exception{
		IvParameterSpec ivParameterSpec=new IvParameterSpec(INIT_VECTOR.getBytes());
		SecretKeySpec secretKeySpec=new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"),"AES");
		
		Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5PADDING");
		 cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
		 
		 byte[] encripted=cipher.doFinal(msg.getBytes());     //Encryption
		 
		 System.out.println("Encrypted Msg ::"+new String(encripted));
		 
		 return Base64.getEncoder().encodeToString(encripted);   //Encoding
	}
//********************************DEcryption*******************************************	
	public static String decryptMsg(String msg) throws Exception {
		IvParameterSpec ivParameterSpec=new IvParameterSpec(INIT_VECTOR.getBytes());
		SecretKeySpec secretKeySpec=new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"),"AES");
		
		Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5PADDING");
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec,ivParameterSpec);
		
	byte[] decoded=	Base64.getDecoder().decode(msg);    //Decoding
		
		byte[] decripted=cipher.doFinal(decoded);  //De-cryption
		
		return new String(decripted);
	}
//***********************************Main method**************************************************	
	public static void main(String[] args) throws Exception {
		String originalValue="india@123";
		System.out.println("Original Msg ::"+originalValue);

		String encryptedEncodedMsg=PwdEncryptDecryptWithASE.encryptMsg(originalValue);
		System.out.println("Encripted +Encoded Msg ::"+encryptedEncodedMsg);
		
		String decryptedMsg=PwdEncryptDecryptWithASE.decryptMsg(encryptedEncodedMsg);
		
		System.out.println("Decrypted Msg ::"+decryptedMsg);
	}

}
