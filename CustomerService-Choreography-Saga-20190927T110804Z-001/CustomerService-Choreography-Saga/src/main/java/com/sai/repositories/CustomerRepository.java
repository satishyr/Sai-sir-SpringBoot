package com.sai.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sai.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Integer>{

	@Modifying
	@Query(value="update customer set amountlimit=amountlimit-?2 where id=?1",nativeQuery=true)
	boolean debitAmountFromCustomer(int custid,double orderamount);
	
}
