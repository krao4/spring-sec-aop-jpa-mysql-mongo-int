/**
 * Created on Feb 13, 2015
 */
package com.sapient.springapp.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.sapient.springapp.domain.Customer;
import com.sapient.springapp.repository.CustomerRepository;
import com.sapient.springapp.service.CustomerService;

/**
 * @author Karthik Rao
 *
 */
@Service("customerService")
@Repository
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Transactional(readOnly=true)
	@Cacheable(value="customers", cacheManager="redisCacheManager")
	public List<Customer> findAll() {
		
		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");

		return Lists.newArrayList(customerRepository.findAll());
	}

	@Transactional(readOnly=true)
	@Cacheable(value="customers", key="#customer.id", cacheManager="redisCacheManager")
	public Customer findById(String id) {
		return customerRepository.findOne(id);
	}

	@CachePut(value="customers", cacheManager="redisCacheManager")
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Transactional(readOnly=true)
	public Page<Customer> findAllByPage(Pageable pageable) {
		return customerRepository.findAll(pageable);
	}	

	@CacheEvict(value="customers",cacheManager="redisCacheManager", key="#customer.id")
	public void delete(Customer customer) {
		customerRepository.delete(customer);
	}
	
	@CacheEvict(value="customers",cacheManager="redisCacheManager", allEntries=true)
	public void cleanCache(Customer customer) {
		//customerRepository.deleteAll();
	}
	
}
