package jp.co.ugatria.base.tag;

public class PageFunctions {

	public static String[] seq(int offset, int num, int max) {
		int mid = num / 2;
		if (num > max || offset <= mid) {
			// 少ないほう
			offset = 1;
		} else if (offset > max - mid) {
			// 多いほう
			offset = max - num + 1;
		} else {
			offset -= mid;
		}
		String[] pages = new String[Math.min(num, max)];
		for (int i = 0; i < pages.length; i++, offset++) {
			pages[i] = Integer.toString(offset);
		}
		return pages;
	}
}