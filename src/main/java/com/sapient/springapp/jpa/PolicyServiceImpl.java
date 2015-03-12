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
import com.sapient.springapp.domain.Policy;
import com.sapient.springapp.repository.PolicyRepository;
import com.sapient.springapp.service.PolicyService;

/**
 * @author Karthik Rao
 *
 */
@Service("policyService")
@Repository
@Transactional
@Cacheable(value="policies", cacheManager="cacheManager")
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyRepository policyRepository;

	@Cacheable(value="policies", cacheManager="cacheManager")
	@Transactional(readOnly=true)
	public List<Policy> findAll() {
		return Lists.newArrayList(policyRepository.findTop4By());		
		//return Lists.newArrayList(policyRepository.findAll());
	}

	@Transactional(readOnly=true)
	@CachePut(value="policies", key="#id", cacheManager="cacheManager")
	public Policy findById(Long id) {
		return policyRepository.findOne(id);
	}

	public Policy save(Policy policy) {
		return policyRepository.save(policy);
	}

	@Transactional(readOnly=true)
	public Page<Policy> findAllByPage(Pageable pageable) {
		return policyRepository.findAll(pageable);
	}	

	@CacheEvict(value="policies", key="#policy.id", cacheManager="cacheManager")
	public void delete(Policy policy) {
		policyRepository.delete(policy);
	}

	/**
	 * Demonstrate transaction timeout
	 */
/*	@Cacheable(value="policies", cacheManager="cacheManager")
	@Transactional(readOnly=true, timeout=1)
	public List<Policy> findAll() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Lists.newArrayList(policyRepository.findAll());
	}
*/		
	
	/**
	 * Demonstrate top20 records fetch
	 */
/*	
 * 	@query=""
  	List<Policy> findTop20Policies() {
		
	}
*/	
	
	/**
	 * Demonstrate cache cleaning!
	 */
	@CacheEvict(value="policies",  cacheManager="cacheManager", allEntries=true)
	public void cleanCache() {
		//customerRepository.deleteAll();
	}	
	
}
