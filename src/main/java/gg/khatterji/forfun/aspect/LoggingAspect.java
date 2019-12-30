package gg.khatterji.forfun.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

     /**
     * Pointcut that matches all repositories, services and Web REST endpoints.
     */
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restControllerPointcut() {
    }

    /**
     * Advice that logs when a RestController method is entered and exited.
     *
     * @param joinPoint join point for advice
     * @return result
     * @throws Throwable throws IllegalArgumentException
     */
    @Around("restControllerPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        try {
            logger.info("Enter: {}.{}() - with argument(s): {}", className, methodName, Arrays.toString(joinPoint.getArgs()));
            long elapsedTime = System.currentTimeMillis() - start;
            Object result = joinPoint.proceed();
            Thread.sleep(2000);
            logger.info("Exit: {}.{}() - execution time: [{} ms] - with result: {}", className, methodName, elapsedTime, result.toString());
            return result;
        } catch (IllegalArgumentException e) {
            logger.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()), className, methodName);
            throw e;
        }
    }

    //TODO
    //before -> Any resource annotated with @Controller annotation
    //and all method and function taking HttpServletRequest as first parameter
//    @Before("within(@org.springframework.web.bind.annotation.RestController *) && args(..,request)")
//    public void logBefore(JoinPoint joinPoint, HttpServletRequest request) {
//        if (request != null) {
//            logger.info("Start Header Section of request ");
//            logger.info("Method Type : " + request.getMethod());
//            Enumeration headerNames = request.getHeaderNames();
//            while (headerNames.hasMoreElements()) {
//                String headerName = (String) headerNames.nextElement();
//                String headerValue = request.getHeader(headerName);
//                logger.info("Header Name: " + headerName + " Header Value : " + headerValue);
//            }
//            logger.info("Request Path info :" + request.getServletPath());
//            logger.info("End Header Section of request ");
//        }
//    }
}
