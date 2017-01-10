package com.example.util;

import java.security.KeyPair;

import org.junit.Test;

import com.example.common.util.AES256CipherUtil;

public class AES256CipherUtilTest {

	@Test
	public void test() {
		String input = "가나다라마바사";
		
		try {
			String encodeStr = AES256CipherUtil.encryptByAES(input);
			String decodeStr = AES256CipherUtil.decryptByAES(encodeStr);
			System.out.format("string = %s\n", input);
			System.out.format("encode string = %s\n", encodeStr);
			System.out.format("decode string = %s\n", decodeStr);
			
			KeyPair keypair = AES256CipherUtil.keyPairByRSA();
			encodeStr = AES256CipherUtil.encryptByRSA(keypair.getPublic(), input);
			decodeStr = AES256CipherUtil.decryptByRSA(keypair.getPrivate(), encodeStr);
			System.out.format("string = %s\n", input);
			System.out.format("keypair private = %s\n", keypair.getPrivate().toString());
			System.out.format("keypair public = %s\n", keypair.getPublic().toString());
			System.out.format("encode string = %s\n", encodeStr);
			System.out.format("decode string = %s\n", decodeStr);
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
