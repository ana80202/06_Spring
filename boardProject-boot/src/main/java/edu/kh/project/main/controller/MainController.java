package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

	@RequestMapping("/") // "/" 최상위 경로 요청 매핑(메서드 가리지 않음)
	public String mainPage() {

		// 접두사/접미사 제외한 경로만 작성
		return "common/main";
	}

	// LoginFilter -> loginError 리다이렉트
	// -> message 만들어서 메인페이지로 리다이렉트
	@GetMapping("loginError")
	public String loginError(RedirectAttributes ra) {

		ra.addFlashAttribute("message", "로그인 후 이용해주세요");
		return "redirect:/";
	}
}
