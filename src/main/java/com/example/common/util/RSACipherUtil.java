package com.example.common.util;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RSACipherUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(RSACipherUtil.class);

	public static KeyPair randomKeyPair() throws Exception {
		SecureRandom secureRandom = new SecureRandom();
		
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");// "SunJSSE"
		keyPairGenerator.initialize(2048, secureRandom);
		
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		
		logger.debug("keypair public-key = " + Hex.encodeHexString(keyPair.getPublic().getEncoded()));
		logger.debug("keypair private-key = " + Hex.encodeHexString(keyPair.getPrivate().getEncoded()));
		logger.debug("keypair public-key = " + Base64.encodeBase64String(keyPair.getPublic().getEncoded()));
		logger.debug("keypair private-key = " + Base64.encodeBase64String(keyPair.getPrivate().getEncoded()));
		
		return keyPair;
	}
	
	public static String encryptByRSA(String input, Key publicKey) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] cipherByte = cipher.doFinal(input.getBytes("utf-8"));
		return Base64.encodeBase64String(cipherByte);
	}
	
	public static String decryptByRSA(String input, Key privateKey) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] inputByte = Base64.decodeBase64(input);
		return new String(cipher.doFinal(inputByte), "utf-8");
	}	
	
}
