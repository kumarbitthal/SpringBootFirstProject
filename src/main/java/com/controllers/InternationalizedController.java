package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class InternationalizedController {

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/greetings")
	public String greetingPage() {
		return messageSource.getMessage("greeting.message", null, LocaleContextHolder.getLocale());
	}
	
}
