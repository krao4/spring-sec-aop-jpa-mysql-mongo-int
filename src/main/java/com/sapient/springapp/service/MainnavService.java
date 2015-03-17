package com.sapient.springapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.common.collect.Lists;
import com.sapient.springapp.domain.Mainnav;
import com.sapient.springapp.repository.MainnavRepository;

@Service("mainNavService")
public class MainnavService {

	final Logger logger = LoggerFactory.getLogger(MainnavService.class);	
	
	@Autowired
	private MainnavRepository mainnavRepository;
	
	@Transactional(readOnly=true)
	//@Cacheable(value="mainnav", cacheManager="redisCacheManager")
	public List<Mainnav> findAll() {
		
		logger.info("main nav details");
		logger.info("-------------------------------");

		return mainnavRepository.findAll();
	}

	public Mainnav save(Mainnav navjson) {
		
		logger.info("save main nav");
		logger.info("-------------------------------");
		return mainnavRepository.save(navjson);
	}	
}
