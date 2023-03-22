package com.bank.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.entity.PassBook;
@Repository
public interface PassBookRepository extends JpaRepository<PassBook, Long> {

	void save(int deposite);

	@Query(value="select * from pass_book where account_number=:account", nativeQuery = true)
	public  Optional<PassBook> findByCustomerAccountNumber(String account);





}
