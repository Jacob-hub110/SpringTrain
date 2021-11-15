package com.korepetycjespring.library;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class ErrorDto {

    private LocalDateTime timestamp;
    private String message;
    private Integer status;
    private String path;

}
