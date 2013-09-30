package com.sanjeeb.webclient;

import java.net.URI;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public class Listener {
	RestTemplate restTemplate;
	String uri;
	String jsonRequestFormat;
	HttpHeaders httpHeaders;
	
	
	public HttpHeaders getHttpHeaders() {
		return httpHeaders;
	}
	
	public void setHttpHeaders(HttpHeaders httpHeaders) {
		this.httpHeaders = httpHeaders;
	}

	public String getJsonRequestFormat() {
		return jsonRequestFormat;
	}	
	
	@Required
	public void setJsonRequestFormat(String jsonRequestFormat) {
		this.jsonRequestFormat = jsonRequestFormat;
	}

	public String getUri() {
		return uri;
	}

	@Required
	public void setUri(String uri) {
		this.uri = uri;
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}
	
	@Required
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}