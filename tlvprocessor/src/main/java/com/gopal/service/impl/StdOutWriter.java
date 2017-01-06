package com.gopal.service.impl;

import com.gopal.service.WriterService;

public class StdOutWriter implements WriterService {

	@Override
	public void write(Object obj) {
		System.out.println(obj);
	}

}
