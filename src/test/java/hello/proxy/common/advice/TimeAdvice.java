package hello.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

@Slf4j
public class TimeAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        log.info("call TimeProxy");
        long startTime = System.currentTimeMillis();

//        Object result = method.invoke(target, args);
        Object result = invocation.proceed();
        // 알아서 target을 호출하고 파라미터를 전달하여 실행

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("end TimeProxy, resultTime={}", resultTime);

        return result;

    }
}
