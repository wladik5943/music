package by.tms.music.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalTime;


@Aspect
@Component
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* by.tms.music.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Executing method: {}",  joinPoint.getSignature().toShortString());
    }

    @AfterReturning(pointcut = "execution(* by.tms.music.controller.*.*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        logger.info("Executing method: {}",  joinPoint.getSignature().toShortString());
        logger.info("Method return: {}", result);
    }

//    @Around("execution(* by.tms.music.controller.*.*(..))")
//    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        logger.info( LocalTime.now() + "  start method: {}",  joinPoint.getSignature().toShortString());
//        joinPoint.proceed();
//        logger.info(LocalTime.now() + " end method: {}",  joinPoint.getSignature().toShortString());
//    }

}
