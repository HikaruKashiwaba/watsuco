package jp.co.ugatria.base.service;

import java.util.Properties;

import jp.co.ugatria.base.exeption.IllegalAccessParamException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractService {

	@Autowired
	@Qualifier("systemSettings")
	private Properties systemSettings;


	/**
	 *
	 * @param name
	 * @return
	 */
	protected String getSystemSetting(String name) {
		return systemSettings.getProperty(name);
	}

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
