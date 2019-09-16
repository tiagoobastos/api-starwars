
package br.com.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = ApiStarwarsApplication.class)
@ActiveProfiles("test")
public class ApiStarwarsApplicationTests {
	
	@Test
	public void contextLoads() {
		
		
	}

}
