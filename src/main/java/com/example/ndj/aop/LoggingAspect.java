package com.example.ndj.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    /*
    *    execution: 메서드 실행 지점을 기반으로 메서드의 시그니처를 사용하여 선택합니다. 가장 일반적으로 사용되는 포인트컷입니다. 예를 들어 execution(* com.example.service.*.*(..))는 com.example.service 패키지 내의 모든 메서드를 대상으로 합니다.
    *    within: 특정 클래스나 패키지 내부의 메서드를 선택합니다. 클래스 레벨의 선택을 제공합니다. within(com.example.service.*)는 com.example.service 패키지 내부의 모든 메서드를 대상으로 합니다.
    *    args: 메서드의 매개변수 타입을 기반으로 선택합니다. 예를 들어 args(java.lang.String)는 String 타입의 매개변수를 가진 모든 메서드를 대상으로 합니다.
    *    annotation: 특정 어노테이션을 사용하여 메서드를 선택합니다. 예를 들어 @Transactional 어노테이션이 있는 메서드를 선택할 수 있습니다.
    *    target: 특정 타입의 객체에 대한 호출을 선택합니다. 예를 들어 target(com.example.service.MyService)는 MyService 타입의 객체를 대상으로 합니다.
    *    this: 현재 프록시된 객체에 대한 호출을 선택합니다. 예를 들어 this(com.example.service.MyService)는 현재 프록시된 객체가 MyService 인터페이스를 구현한 경우에 대한 호출을 선택합니다.
    *    bean: Spring 빈의 이름을 기반으로 선택합니다. 예를 들어 bean(myService)는 이름이 "myService"인 빈에 대한 호출을 선택합니다.
    * */

    @Before("execution(* com.example.ndj.controller.*.*(..))")
    public void logBeforeMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("클라이언트의 요청 시 전 aop 메소드: " + methodName);
    }

    @After("execution(* com.example.ndj.controller.*.*(..))")
    public void logAfterMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("클라이언트의 요청 시 후 aop 메소드: " + methodName);
    }
}
