package com.example.common.util;

import org.junit.Test;

public class AESCipherUtilTest {

	@Test
	public void test() {
		String input = "가나다라마바사아자차카타파하123456789ABCDEFGHIJKLMN";
		
		try {
			String encodeStr = AESCipherUtil.encryptByAES(input);
			String decodeStr = AESCipherUtil.decryptByAES(encodeStr);
			System.out.format("string = %s\n", input);
			System.out.format("encode string = %s\n", encodeStr);
			System.out.format("decode string = %s\n", decodeStr);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
