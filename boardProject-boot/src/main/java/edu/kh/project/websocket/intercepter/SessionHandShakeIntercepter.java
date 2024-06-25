package edu.kh.project.websocket.intercepter;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import jakarta.servlet.http.HttpSession;

/**
 * SessionHandShakeIntercepter 클래스
 * 
 * WebsocketHandler가 동작하기 전/후에 연결된 클라이언트 세션을 가로채는 동작을 작성할 클래스
 */
@Component // bean 으로 등록
public class SessionHandShakeIntercepter implements HandshakeInterceptor {

	// before 먼저 오버라이딩하기
	// 핸들러 동작 전에 수행되는 메서드
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {

		// ServerHttpRequset : HttpServletReauest 의 부모 인터페이스
		// ServerHttpResponse : HttpServletResponse 의 부모 인터페이스

		// attributes : 해당 맵에 세팅된 속성 (데이터) 은
		// 다음에 동작할 Handler 객체에게 전달됨
		// (HandshakeIntercepter -> Handler 데이터 전달하는 역할)

		// 여기서 다운캐스팅 후 뽑아오기
		// request 가 참조하는 객체가
		// ServletServerHttpReqsuet 로 다운 캐스팅이 가능한가?
		if (request instanceof ServletServerHttpRequest) {

			// 다운캐스팅
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;

			// 웹소켓 동작을 요청한 클라이언트의 세션을 얻어옴
			HttpSession session = servletRequest.getServletRequest().getSession();

			// 가로챈 세션을 Handler에 전달할 수 있게 값을 세팅
			attributes.put("session", session);

		}

		return true; // 가로채기 진행 여부 true -> true 로 작성해야 세션을 가로채서 Handler에게 전달 가능하다!
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {

	}

}