package jp.co.ugatria.base.intercepter;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ResourceSettingIntercepter {

	@Pointcut("execution(public * jp.co.ugatria.base.action.*.*(..))")
	public void pointCut() {
	}

	@Before("pointCut()")
	public void beforeExcecute(JoinPoint joinPoint) {
		joinPoint.getSignature();
		try {
			Object o = joinPoint.getTarget();
			Class<? extends Object> clazz = o.getClass();
			Method method = clazz.getMethod("beforeProcess", (Class<?>[])null);
			method.invoke(o, (Object[])null);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After("pointCut()")
	public void afterExcecute(JoinPoint joinPoint) {
		joinPoint.getSignature();
		try {
			Object o = joinPoint.getTarget();
			Class<? extends Object> clazz = o.getClass();
			Method method = clazz.getMethod("afterProcess", (Class<?>[])null);
			method.invoke(o, (Object[])null);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
