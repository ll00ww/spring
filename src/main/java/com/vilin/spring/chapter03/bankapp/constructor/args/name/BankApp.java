package com.vilin.spring.chapter03.bankapp.constructor.args.name;

import com.vilin.spring.chapter03.bankapp.constructor.args.name.controller.FixedDepositController;
import com.vilin.spring.chapter03.bankapp.constructor.args.name.controller.PersonalBankingController;
import com.vilin.spring.chapter03.bankapp.constructor.args.name.controller.UserRequestController;
import com.vilin.spring.chapter03.bankapp.constructor.args.name.domain.FixedDepositDetails;
import com.vilin.spring.chapter03.bankapp.constructor.args.name.domain.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class BankApp {
	private static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:com/vilin/spring/chapter03/bankapp/constructor/args/name/applicationContext.xml");

		FixedDepositController fixedDepositController = context
				.getBean(FixedDepositController.class);
		fixedDepositController.submit(context
				.getBean(FixedDepositDetails.class).setDepositAmount(100)
				.setEmail("someemail@somedomain.com").setId(1).setTenure(10));
		logger.info("Your fixed deposit details : "
				+ fixedDepositController.get());

		PersonalBankingController personalBankingController = context
				.getBean(PersonalBankingController.class);
		logger.info(personalBankingController.getMiniStatement());

		UserRequestController userRequestController = context
				.getBean(UserRequestController.class);
		userRequestController.submitRequest(new Request());
		logger.info("Submitted user request");
	}
}
