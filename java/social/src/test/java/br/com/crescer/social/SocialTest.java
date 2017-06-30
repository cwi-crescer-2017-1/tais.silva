package br.com.crescer.social;

import br.com.crescer.social.controller.HealthController;
import br.com.crescer.social.controller.LoggedUserController;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author carloshenrique
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("test")
public class SocialTest {
    
    @LocalServerPort
    private int port;
    
    @Autowired
    private TestRestTemplate testRestTemplate;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    private String host;
    
    @Before
    public void setBefore() {
        this.host = "http://localhost:" + port;
    }

    /**
     * Test of health method, of class HealthController.
     */
    @Test
    public void testHealth() {
        assertTrue(testRestTemplate.getForObject(host + HealthController.PATH, Boolean.class));
    }

    /**
     * Test of getUserDetails, of class LoggedUserController.
     */
    @Test
    public void testUser() {
        final String user = testRestTemplate
                .withBasicAuth("teste", "password")
                .getForObject(host + LoggedUserController.PATH, String.class);
        assertTrue(user.contains("teste"));
    }
    
}
