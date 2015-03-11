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

import com.sapient.springapp.domain.Policy;
import com.sapient.springapp.service.PolicyService;

/**
 * @author Karthik Rao
 *
 */
@RequestMapping("/policy")
@RestController
public class PolicyController {

	final Logger logger = LoggerFactory.getLogger(PolicyController.class);	
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	private PolicyService policyService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Policy> list() {
		logger.info("Listing policies");
		List<Policy> policies = policyService.findAll();
		logger.info("No. of policies: " + policies.size());
		
		return policies;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(@PathVariable Long id) {
		logger.info("Deleting policy with id: " + id);
		Policy policy = policyService.findById(id);
		policyService.delete(policy);
		logger.info("Policy deleted successfully");		
	}
	
	@RequestMapping(value="cleanCache", method = RequestMethod.GET)
	public void cleanCache() {
		logger.info("cleanCache");
		policyService.cleanCache();
		logger.info("cleanCache");
	}	
	
	
	
}
