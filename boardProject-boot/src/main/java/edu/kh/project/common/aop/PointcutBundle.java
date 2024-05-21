package edu.kh.project.common.aop;

import org.aspectj.lang.annotation.Pointcut;

//Pointcut : 실제 Advice가 적용될 지점
//Pointcut 모아두는 클래스
public class PointcutBundle {

	// 작성하기 어려운 Pointcut 을 미리 작성해두고
	// 필요한 곳에서 클래스명.메서드명() 으로 호출해서 사용가능

	// ex) @Before("execution(* edu.kh.project..*Controller*.*(..))")
	// == @Before("PointBundle.controllerPointCut()")

	@Pointcut("execution(* edu.kh.project..*Controller*.*(..))") // * edu.kh.project 이 부분 띄어쓰기 주의!!!꼭 들어가야함
	public void controllerPointCut() {
	}

	@Pointcut("execution(* edu.kh.project..*ServiceImpl*.*(..))")
	public void ServiceImplPointCut() {
	}

}
