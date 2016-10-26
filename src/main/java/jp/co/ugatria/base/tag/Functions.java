package jp.co.ugatria.base.tag;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import jp.co.ugatria.base.util.DateUtil;

public class Functions {

	private static final String SPACE = "&nbsp;";

	private static final String SPAN_SEPT = "　〜　";

	public static boolean contains(Object collection, Object obj) {
		if (collection == null) {
			return false;
		}
		else if (collection instanceof Object[]) {
			for (Object target : (Object[]) collection) {
				if (target == null) {
					continue;
				}
				if (target.equals(obj)) {
					return true;
				}
			}
		}
		else {
			for (Object target : (Collection<?>) collection) {
				if (target == null) {
					continue;
				}
				if (target.equals(obj)) {
					return true;
				}
			}
		}
		return false;
	}

	public static String formatNumber(String value, String pattern) {
		if (null == value || value.length() == 0) {
			return value;
		}

		DecimalFormat df = new DecimalFormat(pattern);
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(new BigDecimal(value));
	}

	/**
	 * 日付の表示を返却する.
	 * @param value
	 * @return
	 */
	public static String formatDate(Date value) {
		if (value == null) {
			return SPACE;
		}
		return DateUtil.formatDisplay(value);
	}

	/**
	 * 日付期間の表示を返却する.
	 * @param from
	 * @param to
	 * @return
	 */
	public static String formatSpan(Date from, Date to) {
		if (from == null && to == null) {
			return SPACE;
		}
		return formatDate(from) + SPAN_SEPT + formatDate(to);
	}

	public static String outLineBreak(Object o) {
		if (o == null) {
			return "";
		}

		if (o instanceof Number) {
			Number n = (Number) o;
			return n.toString();
		}
		else if (o instanceof String) {
			String s = (String) o;
            // HTML用にサニタイズ処理を施す
            s = StringEscapeUtils.escapeHtml4(s);

            // 改行コードをbrタグに変換する
            s = StringUtils.replace(s, "\r\n", "\n");
            s = StringUtils.replace(s, "\r", "\n");
            s = StringUtils.replace(s, "\n", "<br/>");
			return s;
		}
		else {
			return o.toString();
		}
	}

	/**
	 * 日付の指定月後の前日を返す.
	 * @param date
	 * @param addCnt
	 * @return
	 */
	public static Date beforeDayAfterMonth(Date date, int addCnt) {
		if (date != null) {
			date = DateUtil.addMonth(date, addCnt);
			return DateUtil.addDay(date, -1);
		}
		return null;
	}
}