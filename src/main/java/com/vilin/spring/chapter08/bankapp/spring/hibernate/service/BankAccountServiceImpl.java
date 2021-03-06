package com.vilin.spring.chapter08.bankapp.spring.hibernate.service;


import com.vilin.spring.chapter08.bankapp.spring.hibernate.dao.BankAccountDao;
import com.vilin.spring.chapter08.bankapp.spring.hibernate.domain.BankAccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "bankAccountService")
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	private BankAccountDao bankAccountDao;

	@Override
	@Transactional
	public int createBankAccount(BankAccountDetails bankAccountDetails) {
		return bankAccountDao.createBankAccount(bankAccountDetails);
	}

}
