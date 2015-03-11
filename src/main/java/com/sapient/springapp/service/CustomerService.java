/**
 * Created on Feb 13, 2015
 */
package com.sapient.springapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sapient.springapp.domain.Customer;

/**
 * @author Karthik Rao
 *
 */
public interface CustomerService {

	public List<Customer> findAll();
	
	public Customer findById(String id);
	
	public Customer save(Customer customer);
	
	public Page<Customer> findAllByPage(Pageable pageable);	
	
	public void delete(Customer customer);
}
