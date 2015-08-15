package info.quarrymen.quickstart;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class Application {

  @Autowired
  private RuntimeService runtimeService;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Scheduled(fixedDelay = 10_000)
  public void run() {
    runtimeService.startProcessInstanceByKey("example");
  }
}
