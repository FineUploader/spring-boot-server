package com.fineuploader.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ovaldez
 */
public class UploadResponse {

    @JsonProperty("error")
    private String errorMsg;

    private boolean success;

    public UploadResponse(boolean success) {
        this.success = success;
    }

    public UploadResponse(String errorMsg, boolean success) {
        this.errorMsg = errorMsg;
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
