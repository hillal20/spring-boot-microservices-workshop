package io.javabrains.movieinfoservice;

import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MovieInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieInfoServiceApplication.class, args);
		System.out.println("==== movie info service is running ======");
	}

	@Bean
	public RestTemplate getRestTemplate() {
		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpRequestFactory.setConnectTimeout(3000);
		// if the response comes in 3s is good otherwise throw an exception
		return new RestTemplate(httpRequestFactory);
	}
}

