package com.utils;

import java.util.UUID;

public class UUIDTool {

	public static String getUUID(int length) {
		int benginIndex = 40-length;
		return UUID.randomUUID().toString().replace("-", "").substring(benginIndex);
		
	}
	
}
