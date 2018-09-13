package com.oracle.sb;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 这个类必须配置，如果要将springboot工程发布成war
 *
 * 这个类相当于是配置好让web服务器如何启动该web项目
 */
public class WebStater extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SBApplication.class);
    }
}
