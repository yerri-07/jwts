package com.jwts.jwts;

import com.jwts.jwts.entity.UserDetails;

import com.jwts.jwts.entity.UserResponseInfo;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class JwtsApplication {

	static RestTemplate restTemplate = new RestTemplate();
	static String baseUrl = "http://localhost:8082/";
	public	static void main(String[] args) {

		SpringApplication.run(JwtsApplication.class, args);

	}


	public static UserResponseInfo userExchange(){

		HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Object> requestEntity = new HttpEntity<>(httpHeaders);

		ResponseEntity<UserResponseInfo> responseEntity = restTemplate.exchange(baseUrl+"get", HttpMethod.GET,requestEntity,UserResponseInfo.class);

		HttpStatusCode status =  responseEntity.getStatusCode();

		System.out.println("Status"+status);

		UserResponseInfo user = responseEntity.getBody();

		System.out.println(user);

		HttpHeaders responseHeaders = responseEntity.getHeaders();
		System.out.println(responseHeaders);

			return user;

	}


	public static String userPostExchange(UserDetails userInfo){
		HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Object> requestEntity = new HttpEntity<>(httpHeaders);



		requestEntity = new HttpEntity<>(userInfo,httpHeaders);

		System.out.println("THIS"+requestEntity);

		ResponseEntity<UserDetails>responseEntity = restTemplate.exchange(baseUrl+"post",HttpMethod.POST,requestEntity,UserDetails.class);

		HttpStatusCode status =  responseEntity.getStatusCode();

		System.out.println("Status"+status);

		UserDetails user = responseEntity.getBody();

		System.out.println(user);

		HttpHeaders responseHeaders = responseEntity.getHeaders();
		System.out.println(responseHeaders);

			return "User added";

	}





}


