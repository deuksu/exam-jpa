package com.example.common.util;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncryptUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(EncryptUtil.class);

	public static KeyPair randomKeyPair() throws Exception {
		SecureRandom secureRandom = new SecureRandom();
		
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "SunJSSE");
		keyPairGenerator.initialize(2048, secureRandom);
		
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		
		logger.debug("keypair public-key = " + Hex.encodeHexString(keyPair.getPublic().getEncoded()));
		logger.debug("keypair private-key = " + Hex.encodeHexString(keyPair.getPrivate().getEncoded()));
		
		return keyPair;
	}
	
	
	 // hex string to byte[]
	 public static byte[] hexToByteArray(String hex) {
	     if (hex == null || hex.length() == 0) {
	         return null;
	     }
	     byte[] ba = new byte[hex.length() / 2];
	     for (int i = 0; i < ba.length; i++) {
	         ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
	     }
	     return ba;
	 }
	 
	public static String encryptByRSA(String input, Key publicKey) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING", "SunJSSE");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] cipherByte = cipher.doFinal(input.getBytes("utf-8"));
		return Hex.encodeHexString(cipherByte);
	}
	
	
}
