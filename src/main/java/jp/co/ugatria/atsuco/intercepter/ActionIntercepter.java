package jp.co.ugatria.atsuco.intercepter;

import java.lang.reflect.Method;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import jp.co.ugatria.base.annotation.AsyncRequest;
import jp.co.ugatria.base.annotation.UnnecessaryLogin;
import jp.co.ugatria.base.log.LoggerFactory;
import jp.co.ugatria.atsuco.dto.JsonResponse;
import jp.co.ugatria.atsuco.dto.session.SessionInfo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.view.Viewable;

@Component
@Aspect
public class ActionIntercepter {

	private Logger log = LoggerFactory.make();

	@Autowired
	private SessionInfo session;

	@Pointcut("execution(public * jp.co.ugatria.atsuco.action.*.*(..))")
	public void pointCut() {
	}

	@Around("pointCut()")
	public Response checkProcess(ProceedingJoinPoint pjp) throws Throwable {
		Class clazz = pjp.getTarget().getClass();
		Signature signature = pjp.getSignature();
		Method[] methods = clazz.getMethods();
		String methodName = signature.getName();

		// ログイン不要な処理に設定されている
		UnnecessaryLogin unnecessaryLogin = null;
		// 非同期通信
		AsyncRequest asyncRequest = null;

		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				unnecessaryLogin = (UnnecessaryLogin) method.getAnnotation(UnnecessaryLogin.class);;
				asyncRequest = (AsyncRequest) method.getAnnotation(AsyncRequest.class);
				break;
			}
		}

		if (unnecessaryLogin == null) {
			if (session == null || session.getLoginInfo() == null) {
				log.info("セッションタイムアウト発生");

				// セッションタイムアウト
				if (asyncRequest == null) {
					// 画面遷移でセッションタイムアウト画面へ遷移
					return Response.ok(new Viewable("/sessionTimeout.jsp")).build();
				}
				else {
					// セッションタイムアウトをJSON形式で通知
					Gson gson = new GsonBuilder().create();

					// 非同期通信用のレスポンスを生成
					JsonResponse response = new JsonResponse();
					response.setReturnCode(2);
					response.setErrorMessage("タイムアウトしましたので、再度ログインしてください。");

					// レスポンスを生成
					ResponseBuilder builder = Response.ok(gson.toJson(response), MediaType.APPLICATION_JSON_TYPE);
					builder.type(MediaType.APPLICATION_JSON);
					return builder.build();
				}
			}
		}

		// アクションの処理を実行する
		return (Response) pjp.proceed();
	}
}
