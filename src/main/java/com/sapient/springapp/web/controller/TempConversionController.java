/**
 * Created on Mar 03, 2015
 */
package com.sapient.springapp.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.springapp.service.TempConvService;

/**
 * @author Karthik Rao
 *
 */
@RequestMapping("/tempconv")
@RestController
public class TempConversionController {

	final Logger logger = LoggerFactory.getLogger(TempConversionController.class);	
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	private TempConvService tempConvService;	
	
	@RequestMapping(value = "/{temp}",  method = RequestMethod.GET)
	public String convTemp(@PathVariable String temp) throws Exception{
		String convertedTempVal = tempConvService.convTemp(temp);
		return convertedTempVal;
	}
	
}
