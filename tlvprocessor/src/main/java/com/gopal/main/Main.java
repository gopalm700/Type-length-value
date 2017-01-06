package com.gopal.main;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gopal.service.TlvProcessService;
import com.gopal.service.impl.TlvProcessServiceImpl;

public class Main {

	public static void main(String[] args) {
		Scanner scan = null;
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		TlvProcessService service = ctx.getBean(TlvProcessServiceImpl.class);
		try {
			scan = new Scanner(System.in);
			while (scan.hasNext()) {
				service.process(scan.nextLine());
			}
		} finally {
			if (null != scan) {
				scan.close();
			}
			if (null != ctx) {
				ctx.close();
			}
		}
		
	}

}
