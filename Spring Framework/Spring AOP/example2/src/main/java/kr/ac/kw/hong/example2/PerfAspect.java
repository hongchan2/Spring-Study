package kr.ac.kw.hong.example2;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    // 어디에 적용할 것인가 (포인트 컷)
    @Around("@annotation(PerfLogging)")
    // 해야할 일 (어드바이스)
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
        // pjp 는 적용되는 부분으로 (메소드 그 자체)
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        return retVal;
    }

    @Before("bean(simpleEventService)")
    public void printHello(){
        System.out.println("Hello~");
    }

}
