package com.app;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
@ComponentScan({ " com.controllers", "com.exceptions", "com.documents", "com.beans", "com.services","com.security"})
public class SpringFirstProjectMain {

	public static void main(String[] args) {
		SpringApplication.run(SpringFirstProjectMain.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver slr = new AcceptHeaderLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}
}
