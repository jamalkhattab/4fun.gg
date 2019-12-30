package gg.khatterji.forfun.aspect;

import gg.khatterji.forfun.exception.WebClientResponseExceptionHandler;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Aspect
@Component
public class ExceptionAspect {
    /**
     * Pointcut that matches services that call RiotAPIs.
     */
    @Pointcut("within(gg.khatterji.forfun.service.riotapi.impl.*)")
    public void riotAPIServices() {
    }

    /**
     * Advice that determines the right exception.
     * @param webClientResponseException exception
     */
    @AfterThrowing(pointcut = "riotAPIServices()", throwing = "webClientResponseException")
    public void determineException(WebClientResponseException webClientResponseException) {
       WebClientResponseExceptionHandler.throwCorrespondingResponseStatusException(webClientResponseException);
    }
}
