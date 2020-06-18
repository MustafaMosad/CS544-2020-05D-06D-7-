package com.cs544.group7.reservationService.util;

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

import com.cs544.group7.reservationService.res.ResponseFlight;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.converters.Auto;

@Component
@Configuration
public class CrudServiceCaller {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ServletContext servletContext;

	@Autowired
	private EurekaClient eurekaClient;

	@Value("${crud-service}") // value is coming from the configuration file
	private String remoteServiceName;

	public ResponseFlight getFlight(Integer flightNumber) {
		String url = lookupUrlFor(remoteServiceName) + "/flights//flight/" + flightNumber;
		return restTemplate.exchange(url, HttpMethod.GET, createHttpEntity(), ResponseFlight.class).getBody();
	}

	private HttpEntity<Object> createHttpEntity() {
		HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.setBasicAuth(username, password);
		headers.add("Authorization", (String) servletContext.getAttribute("userToken"));
		return new HttpEntity<>(headers);
	}

	private String lookupUrlFor(String appName) {
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(appName, false);
		return instanceInfo.getHomePageUrl();
	}
}