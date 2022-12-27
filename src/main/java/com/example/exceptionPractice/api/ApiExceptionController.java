package com.example.exceptionPractice.api;

import com.example.exceptionPractice.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ApiExceptionController {
    @GetMapping("/api/members/{id}")
    public MemberDto getMember(@PathVariable("id") String id) {
        if (id.equals("ex")) {
            log.info(id);
            throw new RuntimeException("잘못된 사용자");
        }
        return new MemberDto(id, "홍길동");
    }
}
