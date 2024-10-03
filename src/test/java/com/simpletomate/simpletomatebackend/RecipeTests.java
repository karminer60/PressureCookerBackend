package com.simpletomate.simpletomatebackend;

import com.simpletomate.model.Recipe;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RecipeTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    @Test
    void contextLoads() {
    }

    @Test
    public void shouldReturn201ResponseIncludingLocationHeaderAndCreateRecipeInOurDatabase() {

        final Recipe newRecipe = new Recipe("Frijoles de la olla", "Here is where it goes.", true);

        final ResponseEntity<String> response = template.postForEntity(String.format("http://localhost:%d/api/customers", port), newRecipe, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNull();
        assertThat(response.getHeaders().getLocation().toString()).isEqualTo(String.format("http://localhost:%d/api/customers/0", port));
    }

}
