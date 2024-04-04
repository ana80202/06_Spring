package edu.kh.todo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.service.TodoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j // log객체 자동 생성 -> log 찍어서 볼 수 있음!
@Controller // 요청/ 응답 제어 역할 명시 + Bean 등록
public class MainController {

	@Autowired // DI(의존성 주입)
	private TodoService service;

	@RequestMapping("/") // "/" 최상위 요청
	public String mainPage(Model model) {

		// 의존성 주입(DI) 확인(진자 service 객체 들어옴!)
		log.debug("service : " + service);

		// Service 메서드 호출 후 결과 반환 받기
		Map<String, Object> map = service.selectAll(); // 2가지 기능 :목록조회/카운트 조회

		// map에 담긴 내용 추출
		// List<Todo> todoList = map.get("todoList"); 오류남
		// -> List형으로 다운캐스팅 해줘야함!
		// List<Todo> todoList = (List<Todo>) map.get("todoList");
		List<Todo> todoList = (List<Todo>) map.get("todoList");
		int completeCount = (int) map.get("completeCount");

		// Model : 값 전달용 객체(request scope) + session 반환 가능
		model.addAttribute("todoList", todoList);
		model.addAttribute("completeCount", completeCount);

		// classpath:/templates/ 접두사
		// common/main
		// .html 접미사
		// -> 이쪽으로 forward
		return "common/main";
	}
}
