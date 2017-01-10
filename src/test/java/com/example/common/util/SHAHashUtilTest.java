package com.example.common.util;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class SHAHashUtilTest {

	@Test
	public void test() {
		try {
			String pwd = "vmflfostj2006!@";
			String hash = SHAHashUtil.encode(pwd);
			System.out.format("non-base64 hash value = %s\n",hash);
			System.out.format("base64 hash value = %s\n",Base64.encodeBase64String(pwd.getBytes("utf-8")));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
