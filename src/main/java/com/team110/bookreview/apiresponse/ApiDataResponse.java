package com.team110.bookreview.apiresponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Data
public class ApiDataResponse<T> {

  private HttpStatus status;
  private String message;
  private String errorCode;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private LocalDateTime timestamp;



  public ApiDataResponse() {
    timestamp = LocalDateTime.now();
  }

  public ApiDataResponse(HttpStatus status) {
    this();
    this.status = status;
  }

}