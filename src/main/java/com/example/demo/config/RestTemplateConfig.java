package com.example.demo.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	@Value("${resttemplate.set.time.out}")
	private int restTemplateConnectionTimeOut;
	@Value("${resttemplate.read.time.out}")
	private int restTemplateReadTimeOut;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder ) {
		return builder.setConnectTimeout(Duration.ofMillis(restTemplateConnectionTimeOut))
				.setReadTimeout(Duration.ofMillis(restTemplateReadTimeOut))
				.build();
		
	}
}
