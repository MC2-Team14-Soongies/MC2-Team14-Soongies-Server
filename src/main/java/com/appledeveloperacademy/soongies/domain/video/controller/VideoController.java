package com.appledeveloperacademy.soongies.domain.video.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/videos")
@Tag(name = "비디오 API", description = "비디오 API 입니다.")
public class VideoController {
}
