package com.fineuploader.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @author ovaldez
 */
public class UploadRequest {

    @JsonProperty("qquuid")
    private UUID uuid;

    @JsonProperty("qqfile")
    private MultipartFile file;

    @JsonProperty(value = "qqpartindex", defaultValue = "-1")
    private int chunkIndex;

    @JsonProperty("qqchunksize")
    private long chunkSize;

    @JsonProperty("qqtotalfilesize")
    private long totalSize;

    @JsonProperty("qqfilename")
    private String fileName;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public int getChunkIndex() {
        return chunkIndex;
    }

    public void setChunkIndex(int chunkIndex) {
        this.chunkIndex = chunkIndex;
    }

    public long getChunkSize() {
        return chunkSize;
    }

    public void setChunkSize(long chunkSize) {
        this.chunkSize = chunkSize;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
