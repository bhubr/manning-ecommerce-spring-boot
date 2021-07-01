package me.benoithubert.mngecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("me.benoithubert.mngecom")
public class MngecomApplication {

  public static void main(String[] args) {
    SpringApplication.run(MngecomApplication.class, args);
  }
}
