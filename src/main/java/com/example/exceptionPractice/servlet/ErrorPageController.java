package com.example.exceptionPractice.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;

@Slf4j
@Controller
public class ErrorPageController {
    @RequestMapping(value = "/error-page/500")
    public String errorPage500(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        log.info("errorPage 500");
        return "error-page/500";
    }

//    // api header의 accept type으로 분기
//    @RequestMapping(value = "/error-page/500", produces = MediaType.APPLICATION_JSON_VALUE)
//    public


}
