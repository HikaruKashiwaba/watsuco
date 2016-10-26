package jp.co.ugatria.base.action;

import java.io.InputStream;
import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sun.jersey.api.view.Viewable;

import jp.co.ugatria.base.bean.AbstractBean;
import jp.co.ugatria.base.exeption.IllegalAccessParamException;
import jp.co.ugatria.base.log.LoggerFactory;
import jp.co.ugatria.base.util.DateUtil;

public abstract class AbstractAction {

    private static final String JSP_FILE = "/%s.jsp";

    private Logger log = LoggerFactory.make();

    /** ビュー用パラメータ保持オブジェクト */
	protected Map<String, Object> model = null;

	@Autowired
	@Qualifier("systemSettings")
	private Properties systemSettings;

	protected Response getViewResponse(String jspName) {
		return Response.ok(new Viewable(String.format(JSP_FILE, jspName), model)).build();
	}

	protected Response getViewSystemError() {
		return getViewResponse("systemError");
	}

	protected Response redirect(String url) {
		log.debug(url);
		try {
			if (url.indexOf("?") != -1) {
				url = url + "&ts=" + DateUtil.getCurrentTimestampString();
			}
			else {
				url = url + "?ts=" + DateUtil.getCurrentTimestampString();
			}
			return Response.seeOther(new URI(url)).build();
		}
		catch (Exception e) {
			return getViewSystemError();
		}
	}

	protected Response downloadCSV(String filename, InputStream data) {
		ResponseBuilder builder = Response.ok(data);
		builder.type(MediaType.APPLICATION_OCTET_STREAM);
		try {
			builder.header("Content-Length", data.available());
		}
		catch (Exception e) {
			log.warn("ファイルサイズ取得に失敗しました:[" + filename + "]", e);
		}
		builder.header("Content-Disposition", "attachment;filename=" + encodeFilename(filename));
    	builder.header("X-Content-Type-Options", "nosniff");
		return builder.build();
	}

	/**
	 * ダウンロードファイル名を指定してダウンロード処理を実行する
	 * @param realFileName 登録ファイル名
	 * @param filename 表示ファイル名
	 * @param data
	 * @return
	 */
	protected Response download(String realFileName, String filename, InputStream data) {
		ResponseBuilder builder = Response.ok(data);
		builder.type(MediaType.APPLICATION_OCTET_STREAM);
		try {
			builder.header("Content-Length", data.available());
		}
		catch (Exception e) {
			log.warn("ファイルサイズ取得に失敗しました:[" + realFileName + "]", e);
		}
		builder.header("Content-Disposition", "attachment;filename=" + encodeFilename(filename));
    	builder.header("X-Content-Type-Options", "nosniff");
		return builder.build();
	}

	private static String encodeFilename(String filename) {
		try {
			return URLEncoder.encode(filename, "UTF8");
		}
		catch (Exception e) {
			// 通常起こり得ないエラー、元のファイル名を返しておく
//			log.warn("ファイル名エンコードで例外が発生しました。", e);
			return filename;
		}
	}

	/**
	 * 初期化処理.
	 */
	public abstract void beforeProcess();

	/**
	 * 終了時の共通設定初期化処理.
	 */
	protected abstract void afterProcess();

	/**
	 *
	 * @param name
	 * @return
	 */
	protected String getSystemSetting(String name) {
		return systemSettings.getProperty(name);
	}

	protected void setBean(AbstractBean bean) {
		model.put("bean", bean);
	}

	protected Validator getValidator() {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		return validatorFactory.getValidator();
	}

	/**
	 * 文字列のIDを数値（LONG）に変換する.
	 * @param value 文字列型ID
	 * @return 数値型ID
	 * @throws IllegalAccessParamException : 不正なID
	 */
	protected Long convertKey(String value) {
		if (StringUtils.isNotEmpty(value)) {
			if (StringUtils.isNumeric(value)) {
				return Long.parseLong(value);
			}
			throw new IllegalAccessParamException(
					String.format("データベースのキーとして不正な値が渡されました:%s", value));
		}
		return null;
	}
}
