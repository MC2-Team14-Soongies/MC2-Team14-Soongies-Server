package com.appledeveloperacademy.soongies.domain.test.mapper;

import com.appledeveloperacademy.soongies.domain.member.dto.MemberResponse;
import com.appledeveloperacademy.soongies.domain.test.dto.TestResponse;
import org.springframework.stereotype.Component;

@Component
public class TestMapper {

    public TestResponse.TestAnnaResponse toTestAnnaResponse(String fullName) {
        return TestResponse.TestAnnaResponse.builder()
                .nickname(fullName)
                .build();
    }
}
