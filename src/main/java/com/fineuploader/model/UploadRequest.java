package com.fineuploader.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author ovaldez
 */
public class UploadRequest {

    private final String uuid;
    private final MultipartFile file;
    private int partIndex = -1;
    private long partSize = -1;
    private int totalParts = -1;
    private long totalFileSize = -1;
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

    public int getPartIndex() {
        return partIndex;
    }

    public void setPartIndex(int partIndex) {
        this.partIndex = partIndex;
    }

    public long getPartSize() {
        return partSize;
    }

    public void setPartSize(long partSize) {
        this.partSize = partSize;
    }

    public int getTotalParts() {
        return totalParts;
    }

    public void setTotalParts(int totalParts) {
        this.totalParts = totalParts;
    }

    public long getTotalFileSize() {
        return totalFileSize;
    }

    public void setTotalFileSize(long totalFileSize) {
        this.totalFileSize = totalFileSize;
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
                ", partIndex=" + partIndex +
                ", partSize=" + partSize +
                ", totalParts=" + totalParts +
                ", totalFileSize=" + totalFileSize +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
