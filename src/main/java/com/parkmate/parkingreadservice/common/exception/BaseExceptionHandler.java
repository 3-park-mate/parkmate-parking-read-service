package com.parkmate.parkingreadservice.common.exception;

import com.parkmate.parkingreadservice.common.response.ApiResponse;
import com.parkmate.parkingreadservice.common.response.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class BaseExceptionHandler {

    @ExceptionHandler(BaseException.class)
    protected ApiResponse<Void> BaseError(BaseException e) {
        log.error("BaseException -> {} ({})", e.getStatus(), e.getMessage());
        return ApiResponse.error(e.getStatus());
    }

    @ExceptionHandler(RuntimeException.class)
    protected ApiResponse<Void> RuntimeError(RuntimeException e) {
        log.error("RuntimeException: ", e);
        for (StackTraceElement s : e.getStackTrace()) {
            System.out.println(s);
        }
        return ApiResponse.error(ResponseStatus.INTERNAL_SERVER_ERROR);
    }
}