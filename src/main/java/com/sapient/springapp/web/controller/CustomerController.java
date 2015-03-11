/**
 * Created on Dec 23, 2011
 */
package com.sapient.springapp.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.springapp.domain.Customer;
import com.sapient.springapp.service.CustomerService;

/**
 * @author Karthik Rao
 *
 */
@RequestMapping("/customer")
@RestController
public class CustomerController {

	final Logger logger = LoggerFactory.getLogger(CustomerController.class);	
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> list() {
		logger.info("Listing customers");
		List<Customer> customers = customerService.findAll();
		logger.info("No. of customers: " + customers.size());
		
		return customers;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(@PathVariable String id) {
		logger.info("Deleting customer with id: " + id);
		Customer customer = customerService.findById(id);
		customerService.delete(customer);
		logger.info("Customer deleted successfully");		
	}	
	
}
