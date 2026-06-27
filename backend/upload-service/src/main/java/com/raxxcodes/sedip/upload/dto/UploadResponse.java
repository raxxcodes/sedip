package com.raxxcodes.sedip.upload.dto;

public class UploadResponse {
    private String fileId;
    private String fileName;
    private String status;

    public UploadResponse() {
    }

    public UploadResponse(String fileId, String fileName, String status) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.status = status;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId() {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getStatus(String status) {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}