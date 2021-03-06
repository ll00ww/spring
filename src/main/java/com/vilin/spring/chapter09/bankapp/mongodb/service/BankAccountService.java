package com.vilin.spring.chapter09.bankapp.mongodb.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.vilin.spring.chapter09.bankapp.mongodb.domain.BankAccountDetails;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.scheduling.annotation.Async;

public interface BankAccountService {
	void subtractFromAccount(String bankAccountId, int amount);
	
	String createBankAccount(BankAccountDetails bankAccountDetails);

	BankAccountDetails findByAccountId(String id);

	long countByBalance(int balance);

	List<BankAccountDetails> removeByBalance(int balance);

	List<BankAccountDetails> findByBalance(int balance);

	List<BankAccountDetails> findByFixedDepositsTenureLessThan(int tenure);

	List<BankAccountDetails> findByFixedDepositsFdAmountGreaterThan(int fdAmount);

	List<BankAccountDetails> findTop2ByOrderByFixedDepositsFdCreationDateDesc();

	List<BankAccountDetails> findTop2ByFixedDepositsTenure(int tenure);

	List<BankAccountDetails> findByFixedDepositsTenureAndFixedDepositsFdAmount(int tenure, int fdAmount);

	@Async
	CompletableFuture<List<BankAccountDetails>> findAllByBalanceGreaterThan(int balance);

	@Query("{ 'tenure' : ?0, 'fdAmount' : {'$lte' : ?2}, 'active' : ?3}")
	List<BankAccountDetails> findByCustomQuery(int tenure, int fdAmount, String active);
	
//	Iterable<BankAccountDetails> getHighValueFds();
	
	Iterable<BankAccountDetails> getAllBankAccountsWithoutFds();
	
}
