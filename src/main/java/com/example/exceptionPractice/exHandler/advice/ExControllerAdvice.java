package com.example.exceptionPractice.exHandler.advice;

import com.example.exceptionPractice.exHandler.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice // ControllerAdvice + ResponseBody
public class ExControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illeglExceptionHandler(IllegalArgumentException e) {
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("BAD", e.getMessage());  // RestController 이기 때문에 json으로 반환
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResult exHandler(Exception e) { // 정의되지 않은 에러들이 모두 넘어와서 처리(파라메터의 자식까지 처리)
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("EX", "내부 에러");
    }
}
