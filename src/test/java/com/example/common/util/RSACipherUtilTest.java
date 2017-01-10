package com.example.common.util;

import java.io.PrintStream;
import java.security.KeyPair;

import org.junit.Test;

public class RSACipherUtilTest {

	@Test
	public void test() {
		String input = "가나다라마바사아자차카타파하123456789ABCDEFGHIJKLMN";
		try (PrintStream in = System.out;) {
			KeyPair keypair = RSACipherUtil.randomKeyPair();
			String encryptStr = RSACipherUtil.encryptByRSA(input, keypair.getPublic());
			System.out.format("rsa encrypt string = %s\n", encryptStr);
			System.out.format("rsa decrypt string = %s\n", RSACipherUtil.decryptByRSA(encryptStr, keypair.getPrivate()));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
