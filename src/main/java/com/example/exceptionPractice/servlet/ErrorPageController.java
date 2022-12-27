package com.example.exceptionPractice.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static javax.servlet.RequestDispatcher.ERROR_EXCEPTION;
import static javax.servlet.RequestDispatcher.ERROR_STATUS_CODE;

@Slf4j
@Controller
public class ErrorPageController {
    @RequestMapping(value = "/error-page/500")
    public String errorPage500(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        log.info("errorPage 500");
        return "error-page/500";
    }

    // api header의 accept type으로 분기
    @RequestMapping(value = "/error-page/500", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> errorPage500Api(
            HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, Object> error = new HashMap<>();
        Exception ex = (Exception) request.getAttribute(ERROR_EXCEPTION); // RequestDispacher에 정의됨
        error.put("status", request.getAttribute(ERROR_STATUS_CODE));
        error.put("message", ex.getMessage());

        Integer statusCode = (Integer) request.getAttribute(ERROR_STATUS_CODE);
        return new ResponseEntity<>(error, HttpStatus.valueOf(statusCode));
    }


}
