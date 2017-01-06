package com.gopal.service.impl;

import com.gopal.service.TypeService;

public class REPLCETypeService  implements TypeService{
	private static final String NAME = "REPLCE-";
	@Override
	public String convertToType(String str, int len) {
		return NAME+"THIS STRING";
	}

}
