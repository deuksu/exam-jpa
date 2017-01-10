package com.example.util;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.common.util.SHA256HashUtil;

public class SHA256HashUtilTest {
	
	private static final Logger logger = LoggerFactory.getLogger(SHA256HashUtilTest.class);
	
	@Test
	public void test() {
		try {
			String pwd = "vmflfostj2006!@";
			String hash = SHA256HashUtil.encode(pwd);
			System.out.format("non-base64 hash value = %s\n",hash);
			System.out.format("non-base64 hash value = %s\n",Base64.encodeBase64String(pwd.getBytes("utf-8")));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
