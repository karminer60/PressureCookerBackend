package com.simpletomate.simpletomatebackend;

import com.simpletomate.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CategoryTests {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate template;

	@Test
	void contextLoads() {
	}

	@Test
	public void shouldReturn201ResponseIncludingLocationHeaderAndCreateCategoryInOurDatabase() {

		final Category newCategory= new Category("Rowan Atkinson");

		final ResponseEntity<String> response = template.postForEntity(String.format("http://localhost:%d/api/customers", port), newCategory, String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNull();
		assertThat(response.getHeaders().getLocation().toString()).isEqualTo(String.format("http://localhost:%d/api/customers/0", port));
	}

}

