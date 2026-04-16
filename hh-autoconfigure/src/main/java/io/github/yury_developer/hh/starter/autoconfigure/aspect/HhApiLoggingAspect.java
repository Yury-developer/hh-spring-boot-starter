package io.github.yury_developer.hh.starter.autoconfigure.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/*
 Аспект для логирования запросов (Опционально)
 */
@Slf4j
@Aspect
@Component
@ConditionalOnProperty(prefix = "hh.api", name = "logging-enabled", havingValue = "true", matchIfMissing = false)
public class HhApiLoggingAspect {

    @Around("execution(* io.github.yury.developer.hh.autoconfigure.client.HhApiClient.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        try {
            Object result = joinPoint.proceed();
            long duration = System.currentTimeMillis() - start;
            log.info("HH.ru API call {} completed in {} ms",
                    joinPoint.getSignature().getName(), duration);
            return result;
        } catch (Exception e) {
            long duration = System.currentTimeMillis() - start;
            log.error("HH.ru API call {} failed after {} ms: {}",
                    joinPoint.getSignature().getName(), duration, e.getMessage());
            throw e;
        }
    }
}
