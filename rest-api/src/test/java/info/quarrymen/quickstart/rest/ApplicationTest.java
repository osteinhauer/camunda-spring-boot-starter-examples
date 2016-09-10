package info.quarrymen.quickstart.rest;

import static org.junit.Assert.assertEquals;

import org.camunda.bpm.engine.rest.dto.repository.ProcessDefinitionDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class ApplicationTest {

  private final TestRestTemplate restTemplate = new TestRestTemplate();

  @Value("${local.server.port}")
  private int port;

  @Test
  public void restApiIsAvailable() throws Exception {
    ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:" + port + "/rest/engine/", String.class);
    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertEquals("[{\"name\":\"default\"}]", entity.getBody());
  }

  @Test
  public void restApiProcessDefinitions() throws Exception {
    ResponseEntity<ProcessDefinitionDto[]> entity = restTemplate.getForEntity("http://localhost:" + port + "/rest/process-definition",
        ProcessDefinitionDto[].class);
    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertEquals(1, entity.getBody().length);
    ProcessDefinitionDto processDefinitionDto = entity.getBody()[0];
    assertEquals("example", processDefinitionDto.getName());
  }

}
