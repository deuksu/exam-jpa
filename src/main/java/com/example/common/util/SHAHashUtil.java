package com.example.common.util;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SHAHashUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(SHAHashUtil.class);
	
	public static String encode(String input) throws Exception {
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hash = md.digest(input.getBytes("utf-8"));
		
		logger.info("md hex String = " + Hex.encodeHexString(hash));
		logger.info("md base64 String = " + Base64.encodeBase64String(hash));
		
//		StringBuffer hexString = new StringBuffer();
//		for(int i=0;i<hash.length;i++) {
//			String hex = Integer.toHexString(0xff & hash[i]);
//			if(hex.length()==1) {
//				hexString.append("0");
//			} else {
//				hexString.append(hex);
//			}
//		}
		return Hex.encodeHexString(hash);
	}
}
