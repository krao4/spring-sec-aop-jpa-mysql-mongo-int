/**
 * Created on Feb 13, 2015
 */
package com.sapient.springapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sapient.springapp.domain.Policy;

/**
 * @author Karthik Rao
 *
 */
public interface PolicyService {

	public List<Policy> findAll();
	
	public Policy findById(Long id);
	
	public Policy save(Policy policy);
	
	public Page<Policy> findAllByPage(Pageable pageable);	
	
	public void delete(Policy policy);
	
	public void cleanCache();
}
