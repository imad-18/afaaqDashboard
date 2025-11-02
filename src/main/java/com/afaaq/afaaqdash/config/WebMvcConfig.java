package com.afaaq.afaaqdash.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
@EnableConfigurationProperties(FileStorageProperties.class)
public class WebMvcConfig implements WebMvcConfigurer {

    private final FileStorageProperties properties;

    public WebMvcConfig(FileStorageProperties properties) {
        this.properties = properties;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String relativeUrl = properties.getRelativeUrl();
        if (!relativeUrl.endsWith("/")) {
            relativeUrl = relativeUrl + "/";
        }
        // Map e.g. /uploads/** -> file:/absolute/path/to/base/
        String location = Paths.get(properties.getLocation()).toAbsolutePath().toUri().toString();
        registry.addResourceHandler(relativeUrl + "**")
                .addResourceLocations(location)
                .setCachePeriod(3600); // optional
    }
}
