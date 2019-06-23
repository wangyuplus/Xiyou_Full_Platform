package com.fznsys.xiyou_full_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
@SpringBootApplication
//@EnableCaching
//public class XiyouFullPlatformApplication extends SpringBootServletInitializer {
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(XiyouFullPlatformApplication.class);
//    }
public class XiyouFullPlatformApplication{
    public static void main(String[] args) {
        SpringApplication.run(XiyouFullPlatformApplication.class, args);
    }

}
