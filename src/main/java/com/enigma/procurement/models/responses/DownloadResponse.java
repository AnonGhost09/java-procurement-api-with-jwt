package com.enigma.procurement.models.responses;

import org.springframework.http.HttpStatus;

public class DownloadResponse<T> extends CommonResponse{
    T data;
    String link;
    public DownloadResponse(String message, String link,T data) {
        super.setCode("00");
        super.setMessage(message);
        super.setStatus(HttpStatus.OK.name());
        this.link = link;
        this.data = data;

    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
