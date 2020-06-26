package com.ceiba.core.infraestructura.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class DateTimeFormatConfiguration implements  WebMvcConfigurer  {
	
	
	public void addFormatters(FormatterRegistry registry) {
		DateTimeFormatterRegistrar registrar=new DateTimeFormatterRegistrar();
		registrar.setUseIsoFormat(true);
		registrar.registerFormatters(registry);
	}
	

}

