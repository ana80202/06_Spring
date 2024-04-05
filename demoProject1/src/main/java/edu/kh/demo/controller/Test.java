package edu.kh.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kh.demo.model.dto.TestDTO;

@Controller
@RequestMapping("member")
public class Test {

	@PostMapping("select")
	public String testMethod(@ModelAttribute TestDTO member) {

		return "member/select";
	}

}
