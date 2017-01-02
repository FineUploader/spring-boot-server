package com.fineuploader;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Upload server properties
 *
 * @author ovaldez
 */
@ConfigurationProperties("fineuploader")
public class UploadServerProperties {

    /**
     * Root upload directory.
     */
    private Path baseDir = Paths.get("./uploads");

    public Path getBaseDir() {
        return baseDir;
    }

    public void setBaseDir(Path baseDir) {
        this.baseDir = baseDir;
    }

}
