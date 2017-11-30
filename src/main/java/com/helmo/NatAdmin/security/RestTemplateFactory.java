package com.helmo.NatAdmin.security;

import org.apache.http.HttpHost;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateFactory
	implements FactoryBean<RestTemplate>, InitializingBean {
	
	private RestTemplate restTemplate;
	private final Environment env;
	
	public RestTemplateFactory(Environment env) {
		this.env = env;
	}
	
	@Override
	public RestTemplate getObject() {
		return restTemplate;
	}
	
	@Override
	public Class<?> getObjectType() {
		return RestTemplate.class;
	}
	
	@Override
	public boolean isSingleton() {
		return true;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		HttpHost host = new HttpHost(
				env.getProperty("rest.ip"),
				Integer.parseInt(env.getProperty("rest.port")),
				env.getProperty("rest.protocol"));
		restTemplate = new RestTemplate(
				new HttpComponentsClientHttpRequestFactoryBasicAuth(host)
		);
	}
}
