/**
 * Created on Dec 23, 2011
 */
package com.sapient.springapp.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.springapp.service.BlogService;

/**
 * @author Karthik Rao
 *
 */
@RequestMapping("/blogs")
@RestController
public class BlogController {

	final Logger logger = LoggerFactory.getLogger(BlogController.class);	
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	private BlogService blogService;	
	
	@RequestMapping(method = RequestMethod.GET)
	public String loadBlogs() throws Exception{
		blogService.loadBlogs();
		return "success";
	}
	
}
