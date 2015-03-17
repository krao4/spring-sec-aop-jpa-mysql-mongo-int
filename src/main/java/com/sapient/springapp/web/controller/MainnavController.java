/**
 * Created on Dec 23, 2011
 */
package com.sapient.springapp.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.springapp.domain.Mainnav;
import com.sapient.springapp.service.MainnavService;


/**
 * @author Karthik Rao
 *
 */
@RequestMapping("/mainnav")
@RestController
public class MainnavController {

	final Logger logger = LoggerFactory.getLogger(MainnavController.class);	
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	private MainnavService mainnavService;
	
	@RequestMapping(method = RequestMethod.GET)
	public Mainnav show() {
		logger.info("Listing mainnav");
		Mainnav mainnav = mainnavService.findAll().get(0);
		
		return mainnav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void save(@RequestBody String navjson) {
		logger.info("saving mainnav");
		
		Mainnav mainnav = new Mainnav();
		mainnav.setMainnav(navjson.trim());
		
		mainnavService.save(mainnav);
		
	}
	
}
