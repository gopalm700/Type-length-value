package com.gopal.service.factory;

import com.gopal.service.TypeService;

public interface TypeServiceFactory {
	public TypeService getTypeService (String type);
}
