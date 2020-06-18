package com.cs544.group7.reservationService.security.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cs544.group7.reservationService.security.resp.TokenValidationResponse;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Component
@Configuration
public class AuthenticationServiceCaller {

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${sample-springdata-service}")
	private String serviceName;

	@Value("${validate-api-url}")
	private String validateApiUrl;
	
	@Autowired
	private ServletContext servletContext;

	public TokenValidationResponse authenticateUser(String token) {
		// create headers
		HttpHeaders headers = new HttpHeaders();
		// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);

		// request body parameters
		Map<String, Object> map = new HashMap<>();
		map.put("token", token);

		// build the request
		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

		return restTemplate.exchange(lookupUrlFor(serviceName) + validateApiUrl, HttpMethod.POST, entity,
				TokenValidationResponse.class).getBody();
	}

	private String lookupUrlFor(String appName) {
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(appName, false);
		return instanceInfo.getHomePageUrl();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
