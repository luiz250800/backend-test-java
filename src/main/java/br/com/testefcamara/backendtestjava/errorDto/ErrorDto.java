package br.com.testefcamara.backendtestjava.errorDto;

import java.time.LocalDateTime;

public class ErrorDto {

    private LocalDateTime timestamp = LocalDateTime.now();

    private int status;

    private String message;

    public ErrorDto(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
