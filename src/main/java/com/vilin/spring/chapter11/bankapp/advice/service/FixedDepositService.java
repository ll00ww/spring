package com.vilin.spring.chapter11.bankapp.advice.service;


import com.vilin.spring.chapter11.bankapp.advice.domain.FixedDepositDetails;

public interface FixedDepositService {
	void createFixedDeposit(FixedDepositDetails fdd) throws Exception;
	FixedDepositDetails getFixedDeposit(int fixedDepositId);
}
