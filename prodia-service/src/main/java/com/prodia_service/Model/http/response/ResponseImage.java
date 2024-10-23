package com.prodia_service.Model.http.response;

public class ResponseImage {
    private String job;
    private String status;
    private String imageUrl;
    public ResponseImage(String job, String status, String imageUrl) {
        this.job = job;
        this.status = status;
        this.imageUrl = imageUrl;
    }
    public ResponseImage() {
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
