package com.bitcamp221.didabara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DidabaraApplication {

  public static void main(String[] args) {
    SpringApplication.run(DidabaraApplication.class, args);
  }

}
