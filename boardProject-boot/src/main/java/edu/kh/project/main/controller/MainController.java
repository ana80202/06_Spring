package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/") // "/" 최상위 경로 요청 매핑(메서드 가리지 않음)
	public String mainPage() {

		// 접두사/접미사 제외한 경로만 작성
		return "common/main";

	}
}
