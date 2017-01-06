package com.gopal.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import com.gopal.main.exception.WrongTypeException;
import com.gopal.service.TlvProcessService;
import com.gopal.service.TypeService;
import com.gopal.service.factory.TypeServiceFactory;
import com.gopal.service.factory.WriterServiceFactory;
import com.gopal.utils.TlvUtils;

public class TlvProcessServiceImpl implements TlvProcessService {

	private WriterServiceFactory writerServiceFactory;
	private TypeServiceFactory typeServiceFactory;

	@Override
	public void process(String str) {
		
		String writer = TlvUtils.STD_OUT_WRITER;
		try {
			String[] arr = str.split("-");
			if (null != arr && arr.length >= 3) {
				for (int i = 0; i < arr.length; ) {
					String type = arr[i];
					int len = Integer.parseInt(arr[i+1]);
					String output = arr[i+2];
					if(output.length() > len){
						arr[i+2] = output.substring(len);
						output = output.substring(0,len);
						i += 2;
					}
					else{
						i +=3;
					}
					TypeService service = typeServiceFactory.getTypeService(type);
					if (null != service) {
						output = service.convertToType(output, len);
						writerServiceFactory.getWriterService(writer).write(output);
					} else {
						throw new WrongTypeException();
					}
				}
			} else {
				throw new WrongTypeException();
			}
		} catch (WrongTypeException e) {
			writerServiceFactory.getWriterService(writer).write(TlvUtils.TYPE_NOT_VALID);
			
		} catch (NoSuchBeanDefinitionException e) {
			writerServiceFactory.getWriterService(writer).write(TlvUtils.TYPE_NOT_VALID);
		} 
		catch (Exception e) {
			writerServiceFactory.getWriterService(writer).write(TlvUtils.TYPE_NOT_VALID);
		}
	}

	public WriterServiceFactory getWriterServiceFactory() {
		return writerServiceFactory;
	}

	public void setWriterServiceFactory(WriterServiceFactory writerServiceFactory) {
		this.writerServiceFactory = writerServiceFactory;
	}

	public TypeServiceFactory getTypeServiceFactory() {
		return typeServiceFactory;
	}

	public void setTypeServiceFactory(TypeServiceFactory typeServiceFactory) {
		this.typeServiceFactory = typeServiceFactory;
	}
	
	
	
}
