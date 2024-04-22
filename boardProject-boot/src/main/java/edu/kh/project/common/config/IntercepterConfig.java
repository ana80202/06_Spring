package edu.kh.project.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.kh.project.common.intercepter.BoardTypeIntercepter;

//인터셉터가 어떤 요청을 가로챌지 설정하는 클래스

@Configuration // 서버가 켜지는 내부의 메서드를 모두 수행
public class IntercepterConfig implements WebMvcConfigurer {

	// 인터셉터 클래스 Bean 으로 등록

	@Bean // 개발자가 만들어서 반환하는 객체를 Bean 으로 등록
			// -> 관리는 Spring Container 가 수행
	public BoardTypeIntercepter boardTypeIntercepter() {
		return new BoardTypeIntercepter();
	}

	// 동작할 인터셉터 객체를 추가하는 메서드
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// registry : 등록
		// Bean 으로 등록된 BoardTypeIntercepter를 얻어와서 매개변수로 전달
		registry.addInterceptor(boardTypeIntercepter()).addPathPatterns("/**")// 가로챌 요청주소를 지정
																				// /** : /(최상위주소) 이하 모든 요청 주소
				// 가로채지 않을 주소를 지정
				.excludePathPatterns("/css/**", "/js/**", "/images/**", "/favicon.ico");
	}

}
