package com.vilin.spring.chapter09.bankapp.mongodb.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.vilin.spring.chapter09.bankapp.mongodb.domain.BankAccountDetails;
import com.vilin.spring.chapter09.bankapp.mongodb.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;


@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Override
	public String createBankAccount(BankAccountDetails bankAccountDetails) {
		return bankAccountRepository.save(bankAccountDetails).getAccountId();
	}

	@Override
	public BankAccountDetails findByAccountId(String id) {
		return bankAccountRepository.findByAccountId(id);
	}

	@Override
	public long countByBalance(int balance) {
		return bankAccountRepository.countByBalance(balance);
	}

	@Override
	public List<BankAccountDetails> removeByBalance(int balance) {
		return bankAccountRepository.removeByBalance(balance);
	}

	@Override
	public List<BankAccountDetails> findByBalance(int balance) {
		return bankAccountRepository.findByBalance(balance);
	}

	@Override
	public List<BankAccountDetails> findByFixedDepositsTenureLessThan(int tenure) {
		return bankAccountRepository.findByFixedDepositsTenureLessThan(tenure);
	}

	@Override
	public List<BankAccountDetails> findByFixedDepositsFdAmountGreaterThan(int fdAmount) {
		return bankAccountRepository.findByFixedDepositsFdAmountGreaterThan(fdAmount);
	}

	@Override
	public List<BankAccountDetails> findTop2ByOrderByFixedDepositsFdCreationDateDesc() {
		return bankAccountRepository.findTop2ByOrderByFixedDepositsFdCreationDateDesc();
	}

	@Override
	public List<BankAccountDetails> findTop2ByFixedDepositsTenure(int tenure) {
		return bankAccountRepository.findTop2ByFixedDepositsTenure(tenure);
	}

	@Override
	public List<BankAccountDetails> findByFixedDepositsTenureAndFixedDepositsFdAmount(int tenure, int fdAmount) {
		return bankAccountRepository.findByFixedDepositsTenureAndFixedDepositsFdAmount(tenure, fdAmount);
	}

	@Override
	public CompletableFuture<List<BankAccountDetails>> findAllByBalanceGreaterThan(int balance) {
		return bankAccountRepository.findAllByBalanceGreaterThan(balance);
	}

	@Override
	public List<BankAccountDetails> findByCustomQuery(int tenure, int fdAmount, String active) {
		return bankAccountRepository.findByCustomQuery(tenure, fdAmount, active);
	}

	// -- QuerDsl example
//	@Override
//	public Iterable<BankAccountDetails> getHighValueFds() {
//		Predicate whereClause = QBankAccountDetails.bankAccountDetails.fixedDeposits.any().active.eq("Y")
//				.and(QBankAccountDetails.bankAccountDetails.fixedDeposits.any().fdAmount.gt(1000))
//				.and(QBankAccountDetails.bankAccountDetails.fixedDeposits.any().tenure.between(6, 12));
//		return bankAccountRepository.findAll(whereClause);
//	}
	
	//-- Query by Example
	@Override
	public Iterable<BankAccountDetails> getAllBankAccountsWithoutFds() {
		BankAccountDetails bankAccountDetails = new BankAccountDetails();
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("accountId", "balance", "lastTransactionTimestamp");
		Example<BankAccountDetails> example = Example.of(bankAccountDetails, matcher);
		return bankAccountRepository.findAll(example);
	}
	
	public void subtractFromAccount(String bankAccountId, int amount) {
		bankAccountRepository.subtractFromAccount(bankAccountId, amount);
	}
}