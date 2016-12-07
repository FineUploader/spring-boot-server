package com.fineuploader;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Upload server properties
 * @author ovaldez
 */
@ConfigurationProperties("fineuploader")
public class UploadServerProperties {

    private String baseDir = "./uploads";

    public String getBaseDir() {
        return baseDir;
    }

    public void setBaseDir(String baseDir) {
        this.baseDir = baseDir;
    }

}
