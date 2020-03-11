package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringBootStarterExampleApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@LocalServerPort
	private int port;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testStarterApp() throws IOException {

		String response = testRestTemplate.getForObject("/", String.class);
		assertThat(new ObjectMapper().readTree(response).get("message").textValue()).isEqualTo("Hello World");

	}

	@Test
	public void testAppWithParams() throws IOException {
		String url = "http://localhost:" + this.port;
		URI uri = UriComponentsBuilder.fromHttpUrl(url).path("/scream").queryParam("message", "Hello World").build()
				.toUri();
		String response = testRestTemplate.exchange(uri, HttpMethod.GET, null, String.class).getBody();
		assertThat(new ObjectMapper().readTree(response).get("message").textValue()).isEqualTo("DLROW OLLEH");
		
	}

}
