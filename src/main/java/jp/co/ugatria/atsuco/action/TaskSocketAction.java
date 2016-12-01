package jp.co.ugatria.atsuco.action;

import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import jp.co.ugatria.atsuco.bean.TaskChangeBean;
import jp.co.ugatria.atsuco.bean.TaskCreateBean;
import jp.co.ugatria.atsuco.bean.TaskUpdateBean;
import jp.co.ugatria.atsuco.dto.session.SessionInfo;
import jp.co.ugatria.atsuco.form.JsonForm;
import jp.co.ugatria.atsuco.form.TaskChangeForm;
import jp.co.ugatria.atsuco.form.TaskCreateForm;
import jp.co.ugatria.atsuco.form.TaskUpdateForm;
import jp.co.ugatria.atsuco.service.TaskService;
import jp.co.ugatria.base.log.LoggerFactory;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.core.InjectParam;

@ServerEndpoint(value="/task")
public class TaskSocketAction {

	private Logger log = LoggerFactory.make();

	private EndpointConfig config;

	private TaskService service;

	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		log.info("ソケットオープン：" + session.getId());
		this.config = config;

		ApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
		AutowireCapableBeanFactory factory = context.getAutowireCapableBeanFactory();
		service = (TaskService)factory.autowire(TaskService.class, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, true);
	}

	@OnMessage
	public void onMessage(String message, Session session) {
		log.info("メッセージ受信：" + message);
		Gson gson = new GsonBuilder().create();
		JsonForm jsonForm = gson.fromJson(message, JsonForm.class);

		if (StringUtils.isNotEmpty(jsonForm.getMethod())) {
			if (jsonForm.getMethod().equals("init")) {
				session.getUserProperties().put("projectId", jsonForm.getProjectId());
			} else if (jsonForm.getMethod().equals("update")) {
				// JSONから更新用のパラメータを取得
				TaskUpdateForm form = gson.fromJson(jsonForm.getParam(), TaskUpdateForm.class);
				// タスクの更新を実行
				String result = update(form);
				Set<Session> sessions = session.getOpenSessions();
				for (Session tmp : sessions) {
					// 同一プロジェクトを参照しているクライアントだけを更新する
					if (form.getProjectId().equals(tmp.getUserProperties().get("projectId"))) {
						try {
							// メッセージ送信
							tmp.getBasicRemote().sendText(result);
						} catch (Exception e) {
							// 例外の場合
							e.printStackTrace();
						}
					}
				}
			} else if (jsonForm.getMethod().equals("create")) {
				// JSONから更新用のパラメータを取得
				TaskCreateForm form = gson.fromJson(jsonForm.getParam(), TaskCreateForm.class);
				// タスクの更新を実行
				String result = create(form);
				Set<Session> sessions = session.getOpenSessions();
				for (Session tmp : sessions) {
					// 同一プロジェクトを参照しているクライアントだけを更新する
					if (form.getProjectId().equals(tmp.getUserProperties().get("projectId"))) {
						try {
							// メッセージ送信
							tmp.getBasicRemote().sendText(result);
						} catch (Exception e) {
							// 例外の場合
							e.printStackTrace();
						}
					}
				}
			} else if (jsonForm.getMethod().equals("change")) {
				// JSONから更新用のパラメータを取得
				TaskChangeForm form = gson.fromJson(jsonForm.getParam(), TaskChangeForm.class);
				// タスクの更新を実行
				String resultMessage = change(form);
				Set<Session> sessions = session.getOpenSessions();
				for (Session tmp : sessions) {
					// 同一プロジェクトを参照しているクライアントだけを更新する
					if (form.getProjectId().equals(tmp.getUserProperties().get("projectId"))) {
						try {
							if (tmp.getId().equals(session.getId())) {
								// メッセージ送信
								tmp.getBasicRemote().sendText("{\"message\":\"" + resultMessage + "\",\"method\":\"changeSelf\"}");
							} else {
								// メッセージ送信
								tmp.getBasicRemote().sendText("{\"message\":\"" + resultMessage + "\",\"taskId\":\"" + form.getTaskId() + "\",\"userId\":\"" + form.getUserId() + "\",\"status\":\"" + form.getStatus() + "\",\"method\":\"change\"}");
							}
						} catch (Exception e) {
							// 例外の場合
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	@OnClose
	public void onClose(Session session, CloseReason reason) {
		log.info("ソケットクローズ：" + session.getId());
	}

	@OnError
	public void onError(Session session, Throwable throwable) {
		log.info("ソケットエラー：" + session.getId());
		throwable.printStackTrace();
	}

	private String update(TaskUpdateForm form) {
		TaskUpdateBean bean = new TaskUpdateBean();
		bean.setForm(form);

		service.update(bean);

		return "{\"taskId\":\"" + form.getTaskId() + "\",\"rankNo\":\"" + form.getRankNo() + "\",\"method\":\"update\"}";
	}

	public String create(TaskCreateForm form) {
		TaskCreateBean bean = new TaskCreateBean();
		bean.setForm(form);

		service.create(bean);

		return "{\"userId\":\"" + form.getUserId() + "\",\"taskId\":\"" + bean.getTaskId() + "\",\"rankNo\":\"" + form.getRankNo() + "\",\"method\":\"create\"}";
	}

	public String change(TaskChangeForm form) {
		TaskChangeBean bean = new TaskChangeBean();
		bean.setForm(form);

		service.change(bean);

		String message = "";
		if (form.getStatus().equals("1")) {
			message = "タスクを未着手に変えたよ。";
		} else if (form.getStatus().equals("2")) {
			message = "タスクを仕掛中にしたよ。";
		} else if (form.getStatus().equals("3")) {
			message = "タスクが完了したよ。";
		}

		return message;
	}
}
