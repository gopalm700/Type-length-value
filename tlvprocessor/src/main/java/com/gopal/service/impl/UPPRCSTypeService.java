package com.gopal.service.impl;

import com.gopal.service.TypeService;

public class UPPRCSTypeService implements TypeService {

	private static final String NAME = "UPPRCS-";

	@Override
	public String convertToType(String str, int len) {
		StringBuilder stringBuilder = new StringBuilder(NAME);
		stringBuilder.append(str.toString().substring(0, len).toUpperCase());
		return stringBuilder.toString();
	}

}
