package com.afaaq.afaaqdash.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file.storage")
public class FileStorageProperties {
    /**
     * Absolute base directory for stored files. Default to ${user.home}/app-uploads
     */
    //private String location = System.getProperty("user.home") + "/app-uploads";
    private String location = "C:\\Users\\lenovo\\Documents\\perso_projects\\AfaaqUI\\src\\assets\\images";

    /**
     * Relative URL prefix exposed to clients (must match WebMvc resource mapping).
     * Example: /uploads/
     */
    private String relativeUrl = "/assets/images/";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRelativeUrl() {
        return relativeUrl;
    }

    public void setRelativeUrl(String relativeUrl) {
        this.relativeUrl = relativeUrl;
    }
}
