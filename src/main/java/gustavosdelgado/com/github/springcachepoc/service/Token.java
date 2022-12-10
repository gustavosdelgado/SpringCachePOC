package gustavosdelgado.com.github.springcachepoc.service;

import java.time.LocalDateTime;

public class Token {

    private String accessToken;

    private LocalDateTime crationDateTime;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public LocalDateTime getCrationDateTime() {
        return crationDateTime;
    }

    public void setCrationDateTime(LocalDateTime crationDateTime) {
        this.crationDateTime = crationDateTime;
    }

}
