package info.quarrymen.quickstart.rest;

import org.camunda.bpm.spring.boot.starter.rest.CamundaJerseyResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ CamundaJerseyResourceConfig.class })
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
