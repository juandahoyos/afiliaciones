package com.ceiba.core.infraestructura.configuracion;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;

import com.google.common.cache.CacheBuilder;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;


@Configuration
public class ConfiguracionCache extends CachingConfigurerSupport {

	@Value("${cache.time}")
	private String time;

	@Value("${cache.defaultTime}")
	private int defaultTime;
	
	private int timeCache;

	@Autowired
	public void loadTimeCacheApplication() {
		timeCache = Integer.valueOf(time);
		if (time == null) {
			timeCache = defaultTime;
		}
	}

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager() {
			@Override
			protected Cache createConcurrentMapCache(final String name) {
				return new ConcurrentMapCache(name,
						CacheBuilder.newBuilder().expireAfterWrite(timeCache, TimeUnit.MINUTES).build().asMap(),
						false);
			}
		};
	}

	@Bean
	public KeyGenerator keyGenerator() {
		return new SimpleKeyGenerator();
	}
}