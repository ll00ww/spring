package com.vilin.spring.chapter03.bankapp.types;

import com.vilin.spring.chapter03.bankapp.types.beans.BankDetails;
import com.vilin.spring.chapter03.bankapp.types.beans.CollectionTypesExample;
import com.vilin.spring.chapter03.bankapp.types.beans.DataTypesExample;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SampleApp {
	private static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:com/vilin/spring/chapter03/bankapp/types/applicationContext.xml");
		BankDetails bankDetails = context.getBean(BankDetails.class);
		logger.info(bankDetails);
		
		context.getBean(DataTypesExample.class);
		logger.info("Created context successfully");
		
		logger.info(context.getBean(CollectionTypesExample.class));
	}
}
