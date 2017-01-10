package com.example.util;

import java.security.KeyPair;

import org.junit.Test;

import com.example.common.util.EncryptUtil;

public class EncryptUtilTest {

	@Test
	public void test() {
		String input = "가나다라마바사아자차카타파하";
		try { 
			KeyPair keypair = EncryptUtil.randomKeyPair();
			
			EncryptUtil.encryptByRSA(input, keypair.getPrivate());
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	

}
