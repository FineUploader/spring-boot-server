package com.fineuploader.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author ovaldez
 */
public class UploadRequest {

    private String uuid;

    private MultipartFile file;

    private Integer chunkIndex;

    private long chunkSize;

    private long totalSize;

    private String fileName;

    public UploadRequest(String uuid, MultipartFile file) {
        this.uuid = uuid;
        this.file = file;
    }

    public String getUuid() {
        return uuid;
    }

    public MultipartFile getFile() {
        return file;
    }

    public Integer getChunkIndex() {
        return chunkIndex;
    }

    public void setChunkIndex(Integer chunkIndex) {
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

    @Override
    public String toString() {
        return "UploadRequest{" +
                "uuid='" + uuid + '\'' +
                ", chunkIndex=" + chunkIndex +
                ", chunkSize=" + chunkSize +
                ", totalSize=" + totalSize +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
