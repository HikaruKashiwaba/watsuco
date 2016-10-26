package jp.co.ugatria.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	private static final String CURRENT_TIMESTAMP_FORMAT = "yyyyMMddHHmmssSSS";

	// DB登録用に日付を変換するフォーマッター
	private static final SimpleDateFormat SDF_YYYYMMDD = new SimpleDateFormat("yyyy/MM/dd");
	// 進捗表 登録時専用 フォーマッター
	private static final SimpleDateFormat SDF_YYYYMMDD2 = new SimpleDateFormat("yyyy-MM-dd");
	// 画面表示 標準フォーマッター
	private static final SimpleDateFormat SDF_DISP = new SimpleDateFormat("yyyy年M月d日");

	/**
	 * 主にDBに登録するように日付を変換する.
	 * 不正な文字列が渡された場合には、例外が発生する（バリデーション後の値のため、基本発生しない前提）
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String dateStr) throws ParseException {
		return SDF_YYYYMMDD.parse(dateStr);
	}

	/**
	 * 進捗表から、DBに登録するように日付を変換する.
	 * 不正な文字列が渡された場合には、例外が発生する（バリデーション後の値のため、基本発生しない前提）
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDateTarget(String dateStr) throws ParseException {
		return SDF_YYYYMMDD2.parse(dateStr);
	}

	/**
	 * 指定の定義に従った日付文字列として、解析し日付を返却する.
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date parseDate(String dateStr, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(dateStr);
		}
		catch (Throwable t) {
			return null;
		}
	}

	/**
	 * 日付を画面表示標準のフォーマット（yyyy年M月d日）に変換する.
	 * NULLが渡された場合は、から文字を返却する.
	 * @param date
	 * @return
	 */
	public static String formatDisplay(Date date) {
		if (date == null) {
			return "";
		}
		return SDF_DISP.format(date);
	}

	/**
	 * 指定の定義に従って日付をフォーマットした文字列を返却する.
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 現時刻のタイムスタンプ値（年〜ミリ秒までの17桁の数字）を返却する.
	 * @return
	 */
	public static String getCurrentTimestampString() {
		SimpleDateFormat sdf = new SimpleDateFormat(CURRENT_TIMESTAMP_FORMAT);
		return sdf.format(new Date());
	}

	public static Date getFirstDayOfNextMonth(int year, int month) {
		Calendar cal = GregorianCalendar.getInstance();
		// 時刻を0クリア
		clearTime(cal);
		cal.set(year, month-1, 1);
		cal.add(Calendar.MONTH, 1);
		return cal.getTime();
	}

	public static Date getFirstDayOfMonth(int year, int month) {
		Calendar cal = GregorianCalendar.getInstance();
		clearTime(cal);
		cal.set(year, month-1, 1);
		return cal.getTime();
	}

	private static void clearTime(Calendar cal) {
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
	}


	public static Date addMonth(Date date, int add) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, add);
		return cal.getTime();
	}

	public static Date addDay(Date date, int add) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, add);
		return cal.getTime();
	}

	public static int getDayOfWeek(String dateStr, String format) {
		return getDayOfWeek(parseDate(dateStr, format));
	}

	public static int getDayOfWeek(Date date) {
		return get(date, Calendar.DAY_OF_WEEK);
	}

	public static int get(Date date, int field) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(field);
	}
}
