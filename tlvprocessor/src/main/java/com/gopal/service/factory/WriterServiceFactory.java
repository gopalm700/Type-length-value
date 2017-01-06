package com.gopal.service.factory;

import com.gopal.service.WriterService;

public interface WriterServiceFactory {
	public WriterService getWriterService (String type);
}
