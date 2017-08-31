package com.gnfo.aop;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAspect
{
    private Log log = LogFactory.getLog(this.getClass());
    
//    @Pointcut("execution(* *.*(..))")
//    protected void loggingOperation() {}
//    
//    @Before("loggingOperation()")
//    @Order(1)
//    public void logJoinPoint(JoinPoint joinPoint)
//    {
//        log.info("Join point kind : " + joinPoint.getKind());
//        log.info("Signature declaring type : "+ joinPoint.getSignature().getDeclaringTypeName());
//        log.info("Signature name : " + joinPoint.getSignature().getName());
//        log.info("Arguments : " + Arrays.toString(joinPoint.getArgs()));
//        log.info("Target class : "+ joinPoint.getTarget().getClass().getName());
//        log.info("This class : " + joinPoint.getThis().getClass().getName());
//    }
//        
//    @AfterReturning(pointcut="loggingOperation()", returning = "result")
//    @Order(2)
//    public void logAfter(JoinPoint joinPoint, Object result)
//    {
//        log.info("Exiting from Method :"+joinPoint.getSignature().getName());
//        log.info("Return value :"+result);
//    }
//    
//    @AfterThrowing(pointcut="execution(* *.*(..))", throwing = "e")
//    @Order(3)
//    public void logAfterThrowing(JoinPoint joinPoint, Throwable e)
//    {
//        log.error("An exception has been thrown in "+ joinPoint.getSignature().getName() + "()");
//        log.error("Cause :"+e.getCause());
//    }
//    
//    @Around("execution(* *.*(..))")
//    @Order(4)
//    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable
//    {
//        log.info("The method " + joinPoint.getSignature().getName()+ "() begins with " + Arrays.toString(joinPoint.getArgs()));
//        try
//        {
////            Object result = joinPoint.proceed();
//            log.info("The method " + joinPoint.getSignature().getName()+ "() ends with ");
////            return result;
//        } catch (IllegalArgumentException e)
//        {
//            log.error("Illegal argument "+ Arrays.toString(joinPoint.getArgs()) + " in "+ joinPoint.getSignature().getName() + "()");
//            throw e;
//        }        
//    }
    
    @Before("execution(* com.gnfo.dao.UserDAO.*(..))")
	public void logBefore(JoinPoint joinPoint) {
    	log.info("Join point kind : " + joinPoint.getKind());
    	log.info("logBefore() is running!");
    	log.info("GNFO AOP Entry Logging in method : " + joinPoint.getSignature().getName());
    	log.info("******");
	}
    
    @After("execution(* com.gnfo.dao.UserDAO.*(..))")
	public void logAfter(JoinPoint joinPoint) {

		log.info("logAfter() is running!");
		log.info("GNFO AOP Exit Logging from method : " + joinPoint.getSignature().getName());
		log.info("******");

	}
    
    @Around("execution(* com.gnfo.dao.*.*(..))")
	public Object logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {

			StopWatch stopWatch = new StopWatch();
			stopWatch.start();

			Object retVal = joinPoint.proceed();

			stopWatch.stop();

			StringBuffer logMessage = new StringBuffer();
			logMessage.append(joinPoint.getTarget().getClass().getName());
			logMessage.append(".");
			logMessage.append(joinPoint.getSignature().getName());
			logMessage.append("(");
			// append args
			Object[] args = joinPoint.getArgs();
			for (int i = 0; i < args.length; i++) {
				logMessage.append(args[i]).append(",");
			}
			if (args.length > 0) {
				logMessage.deleteCharAt(logMessage.length() - 1);
			}

			logMessage.append(")");
			logMessage.append(" execution time: ");
			logMessage.append(stopWatch.getTotalTimeMillis());
			logMessage.append(" ms");
			log.info(logMessage.toString());
			return retVal;
	}
    
//	@AfterReturning(pointcut = "execution(* com.gnfo.dao.UserDAO.*(..))", returning = "result")
//	public void logAfterReturning(JoinPoint joinPoint, Object result) {
//
//		log.info("logAfterReturning() is running!");
//		log.info("GNFO AOP : " + joinPoint.getSignature().getName());
//		log.info("Method returned value is : " + result);
//		log.info("******");
//
//	}
//	
//	@AfterThrowing(pointcut = "execution(* com.gnfo.dao.UserDAO.*(..))", throwing = "error")
//	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
//
//		log.info("logAfterThrowing() is running!");
//		log.info("GNFO AOP : " + joinPoint.getSignature().getName());
//		log.info("Exception : " + error);
//		log.info("******");
//
//	}
//	
//	@Around("execution(* com.gnfo.dao.UserDAO.*(..))")
//	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//
//		log.info("logAround() is running!");
//		log.info("GNFO AOP method : "
//				+ joinPoint.getSignature().getName());
//		log.info("GNFO AOP arguments : "
//				+ Arrays.toString(joinPoint.getArgs()));
//
//		log.info("Around before is running!");
//		joinPoint.proceed(); // continue on the intercepted method
//		log.info("Around after is running!");
//
//		log.info("******");
//
//	}
    
}