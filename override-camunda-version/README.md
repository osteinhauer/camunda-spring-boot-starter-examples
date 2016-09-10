# Override camunda version example
This example shows how to override the camunda version using [camunda-bpm-spring-boot-starter](https://github.com/camunda/camunda-bpm-spring-boot-starter).

This example is using camunda version 7.6.0-alpha3 instead of the one coming with the spring boot starter.

**Note:** There is no code for camunda configuration. Just concentrate on your processes!

Simply starts a process every 10 seconds. The delegate is _async before_ so the job executor is invoked.

![example.bpmn](src/main/resources/example.png)
