/**
 * Created on Feb 13, 2015
 */
package com.sapient.springapp.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sapient.springapp.domain.Policy;

/**
 * @author Karthik Rao
 *	Todo - demonstrate a query
 */
@Repository
public interface PolicyRepository extends PagingAndSortingRepository<Policy, Long> {
	
	public List<Policy> findTop4By();       

}