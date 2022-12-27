package com.example.exceptionPractice.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MemberDto {
    private final String memberId;
    private final String name;
}
