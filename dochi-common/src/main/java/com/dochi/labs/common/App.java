package com.dochi.labs.common;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.dochi.labs"})
public class App implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
//        SpringApplication app = new SpringApplication(App.class);
//        app.setBannerMode(Banner.Mode.LOG);
//        ConfigurableApplicationContext cac = app.run(args);
//        cac.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
//            @Override
//            public void onApplicationEvent(ApplicationEvent event) {
//                
//            }
//        });
    }
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
//        log.info("[spring-boot][run]");
    }
}
