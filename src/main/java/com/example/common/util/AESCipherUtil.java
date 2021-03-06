package com.example.common.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AESCipherUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(AESCipherUtil.class);
	private static final String AES256_ALGORITHM = "AES/CBC/PKCS5Padding";
//	private static final String SECURE_KEY ="12345678901234567890123456789012";	//32bit::별도의 라이브러리 필요
	private static final String SECURE_KEY ="1234567890123456";	//16bit
	private static String LV ="";

	static {
		LV = SECURE_KEY.substring(0,16);
	}
	
	public static String encryptByAES(String input) throws Exception {
		SecretKey secretKey = new SecretKeySpec(SECURE_KEY.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance(AES256_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(LV.getBytes()));
		byte[] cipherByte = cipher.doFinal(input.getBytes("utf-8"));
		return Base64.encodeBase64String(cipherByte);
	}
	
	public static String decryptByAES(String input) throws Exception {
		SecretKey secretKey = new SecretKeySpec(SECURE_KEY.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance(AES256_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(LV.getBytes()));
		byte[] decodeBase64Byte = Base64.decodeBase64(input);
		return new String(cipher.doFinal(decodeBase64Byte),"utf-8");
	}	
}
