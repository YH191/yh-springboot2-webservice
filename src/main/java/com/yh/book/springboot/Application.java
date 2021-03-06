package com.yh.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/** 추후 war 빌드 및 배포를 위해 SpringBootServletInitializer 상속*/
@SpringBootApplication
public class Application /*extends SpringBootServletInitializer*/ {
/*

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
*/

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}